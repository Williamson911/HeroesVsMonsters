package be.technifutur.heroesvsmonsters.skills;

import be.technifutur.heroesvsmonsters.characters.Heroes;
import be.technifutur.heroesvsmonsters.combat.CombatAction;
import be.technifutur.heroesvsmonsters.enemies.Monsters;
import be.technifutur.heroesvsmonsters.skills.FireBallSkill;
import be.technifutur.heroesvsmonsters.skills.HealSkill;
import be.technifutur.heroesvsmonsters.skills.Skill;
import be.technifutur.heroesvsmonsters.utils.InputUtils;

import java.util.List;

public class SkillAction implements CombatAction {

    private final List<Skill> skills = List.of(
            new FireBallSkill(),
            new HealSkill()
    );

    @Override
    public String name() {
        return "Skills";
    }

    @Override
    public int enduranceCost() {
        return 0;
    }

    @Override
    public void execute(Heroes hero, Monsters monster) {

        hero.reduceCooldowns();

        System.out.println("\n══ SKILLS ══");

        for (int i = 0; i < skills.size(); i++) {

            Skill s = skills.get(i);

            boolean available = hero.isSkillAvailable(s);
            String status = available ? "" : " (CD)";

            System.out.printf("%d. %s%s%n", i + 1, s.name(), status);
        }

        int choice = InputUtils.readIntInRange(
                1,
                skills.size(),
                "Choisissez un skill : "
        ) - 1;

        Skill skill = skills.get(choice);

        if (!hero.isSkillAvailable(skill)) {
            System.out.println("❌ Skill en cooldown !");
            return;
        }

        if (!hero.hasMana(skill.manaCost())) {
            System.out.println("❌ Pas assez de mana !");
            return;
        }

        hero.consumeMana(skill.manaCost());
        skill.execute(hero, monster);
        hero.setCooldown(skill);
    }
}