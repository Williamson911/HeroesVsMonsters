# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Run

Maven project targeting Java 26. No test suite exists yet.

```bash
# Compiler
mvn compile

# Lancer le jeu
mvn exec:java -Dexec.mainClass="be.technifutur.heroesvsmonsters.Main"

# Packager
mvn package
```

## Architecture

### Vue d'ensemble

RPG textuel en console inspiré de Dark Souls. Le joueur crée un personnage, traverse des zones, combat des monstres et des boss, ramasse des âmes et du loot.

Flux principal (`Main.java`) :
1. `CharacterCreator` → crée un `Heroes` via saisie console + jet de dés 4d6
2. `WorldMap` (construit par `WorldFactory`) → séquence linéaire de `Zone`
3. Boucle d'exploration : déplacement entre zones, rencontres aléatoires (70 %), boss de zone
4. `CombatEngine.start()` orchestre chaque combat tour par tour

### Hiérarchie des personnages

```
Personnage (stats, heal/takeDamage)
├── Heroes   (inventaire, arme équipée, âmes, bloodstain, états de combat)
│   ├── Chevalier / Guerrier / Voleur / Samourai / Aventurier / Bandit
│   └── chaque classe peut overrider applyClassBonus()
└── Monsters (amesReward, dropChance, posture, escape flag)
    └── Boss  (phase2, triggerPhase2 à 50 % HP, getGuaranteedDrops)
```

### Système de stats

`Stat` (abstract) — `baseValue + bonus`, méthodes `augmenter/reduire/addBonus`.

Stats concrètes : `Force`, `Dexterite`, `Intelligence`, `Resistance` héritent de `Stat`.

`Vitalite` et `Endurance` **ne héritent pas de `Stat`** et ont leur propre implémentation :
- `Vitalite` : `valeur` / `max`, pas de regen automatique
- `Endurance` : `current` / `max`, `regen(n)`, `consume(n)`, `reset()` — c'est la **stamina de combat**

`Endurance` sert aussi de réservoir de mana pour les skills (via `consumeMana` / `hasMana` dans `Heroes`).

### Système de combat (`combat/`)

`CombatAction` (interface) — `name()`, `enduranceCost()`, `execute(hero, monster)`.

Actions enregistrées dans `CombatEngine` :
| Action | Stamina | Effet |
|---|---|---|
| `LightAttackAction` | 15 | dégâts arme de base |
| `HeavyAttackAction` | 35 | dégâts × 1.8 |
| `DefendAction` | 0 (5 via `use`) | `hero.defending = true` → dégâts reçus / 2 |
| `DodgeAction` | 20 | `hero.dodging = true` → prochain coup annulé |
| `ParryAction` | 15 | `hero.parryWindow = true` → contre-attaque × 2 si actif avant le tour monstre |
| `ItemAction` | 0 | utilise un item de l'inventaire |
| `SkillAction` | variable | exécute un `Skill` (mana + cooldown) |
| `FleeAction` | 0 | 40 % / 70 % (DEX ≥ 15) de réussir |
| `QuickUsePotionAction` | 0 | première potion trouvée dans l'inventaire |

L'ordre d'évaluation dans `monsterTurn` : parry window → dodge → defend → dégâts bruts.

### Armes et scaling

`Armes extends Item`. Le scaling Force/Dextérité est codé par un `int` 0-6 dans le constructeur (0=aucun … 6=S). L'enum `Scaling` existe mais n'est pas encore branché sur `Armes` (les armes utilisent directement les entiers).

`getDegatsReels(hero)` = `degats` + `force * multiplierForce` + `dex * multiplierDex`

Les classes d'armes concrètes (ex. `EpéesDroites`, `Katanas`, `Dagues`…) sont dans `weapons/` et appellent simplement le super-constructeur avec les valeurs voulues.

### Items

`Item` (abstract) — `getNom()`, `utiliser(Heroes) : int`.
- `Armes extends Item` (retourne 0 à l'utilisation)
- `Potion extends Item` → `PotionSoin` (heal fixe), `PotionMana` (restaure endurance)
- `Titanites` — objet de forge (logique d'upgrade à implémenter)
- `Inventaire` — classe utilitaire séparée, peu utilisée ; l'inventaire actif est le `Map<Item, Integer>` dans `Heroes`

`Item.equals/hashCode` sont basés sur le **nom** : deux items avec le même nom sont considérés identiques dans l'inventaire.

### Monde (`world/`)

- `Zone` : liste de monstres aléatoires + un boss + `encounterChance`
- `WorldMap` : liste ordonnée de `Zone` + index courant, `moveNextZone()` / `movePreviousZone()`
- `WorldBuilder` / `WorldFactory` : factories statiques qui instancient le monde (Main référence `WorldFactory`)

### Skills (`skills/`)

`Skill` (interface) — `name()`, `manaCost()`, `cooldown()`, `execute(hero, monster)`.

Les cooldowns sont gérés dans `Heroes` via une `Map<String, Integer>` (clé = nom du skill). `reduceCooldowns()` est à appeler à chaque tour. Exemples : `FireBallSkill` (INT × 2 dégâts, mana 15, CD 2), `HealSkill`.

### UI utilitaires

- `CombatUI` : animations console, délais `sleep()`, constantes ANSI `GREY`/`RESET`
- `UIUtils` : barres colorées `coloredBar()` (HP, stamina)
- `InputUtils` : `readIntInRange()`, `readString()`, `menu()` — toutes les lectures console passent par là
