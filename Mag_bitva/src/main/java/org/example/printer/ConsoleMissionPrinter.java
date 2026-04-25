package org.example.printer;

import org.example.model.Mission;
import org.example.model.Parts_of_the_mission.*;

import java.util.List;

public class ConsoleMissionPrinter implements MissionPrintStrategy {

    @Override
    public void print(Mission mission) {
        if (mission == null) {
            System.out.println("Ошибка: миссия не загружена.");
            return;
        }

        System.out.println("=".repeat(70));
        System.out.println("МИССИЯ: " + mission.getMissionId());
        System.out.println("Дата:     " + (mission.getDate() != null ? mission.getDate() : "—"));
        System.out.println("Место:    " + (mission.getLocation() != null ? mission.getLocation() : "—"));
        System.out.println("Статус:   " + (mission.getOutcome() != null ? mission.getOutcome() : "UNKNOWN"));
        System.out.println("Урон:     " + (mission.getDamageCost() != null ? mission.getDamageCost() + " ¥" : "—"));

        if (mission.getNote() != null && !mission.getNote().isEmpty()) {
            System.out.println("Примечание: " + mission.getNote());
        }

        System.out.println("=".repeat(70));

        // Проклятие (выводим только если есть данные)
        printCurse(mission.getCurse());

        // Участники
        printSorcerers(mission.getSorcerers());

        // Применённые техники
        printTechniques(mission.getTechniques());

        // Дополнительные блоки — выводим только если они заполнены
        printEconomicAssessment(mission.getEconomicAssessment());
        printCivilianImpact(mission.getCivilianImpact());
        printEnemyActivity(mission.getEnemyActivity());
        printEnvironmentConditions(mission.getEnvironmentConditions());
        printOperationTimeline(mission.getOperationTimeline());

        // Списки (теги, рекомендации и т.д.)
        printStringList("Теги операции", mission.getOperationTags());
        printStringList("Поддержка", mission.getSupportUnits());
        printStringList("Рекомендации", mission.getRecommendations());
        printStringList("Артефакты", mission.getArtifactsRecovered());
        printStringList("Зоны эвакуации", mission.getEvacuationZones());
        printStringList("Статусные эффекты", mission.getStatusEffects());

        System.out.println("=".repeat(70));
        System.out.println("Анализ миссии завершён.\n");
    }

    private void printCurse(Curse curse) {
        if (curse == null || (curse.getName() == null || curse.getName().isEmpty())) {
            return; // не выводим пустой блок
        }
        System.out.println("\nПРОКЛЯТИЕ:");
        System.out.println("  Имя:           " + curse.getName());
        System.out.println("  Уровень угрозы: " + curse.getThreatLevel());
    }

    private void printSorcerers(List<Sorcerer> sorcerers) {
        if (sorcerers == null || sorcerers.isEmpty()) return;
        System.out.println("\nУЧАСТНИКИ:");
        for (Sorcerer s : sorcerers) {
            System.out.println("  - " + s.getName() + " (" + s.getRank() + ")");
        }
    }

    private void printTechniques(List<Technique> techniques) {
        if (techniques == null || techniques.isEmpty()) return;
        System.out.println("\nПРИМЕНЁННЫЕ ТЕХНИКИ:");
        for (Technique t : techniques) {
            long damage = t.getDamage() != null ? t.getDamage() : 0;
            System.out.printf("  * %s [%s] (владелец: %s) урон: %d%n",
                    t.getName() != null ? t.getName() : "—",
                    t.getType() != null ? t.getType() : "—",
                    t.getOwner() != null ? t.getOwner() : "—",
                    damage);
        }
    }

    private void printEconomicAssessment(EconomicAssessment ea) {
        if (ea == null) return;
        System.out.println("\nЭКОНОМИЧЕСКАЯ ОЦЕНКА:");
        System.out.println("  Общий ущерб:          " + ea.getTotalDamageCost() + " ¥");
        System.out.println("  Инфраструктура:       " + ea.getInfrastructureDamage() + " ¥");
        System.out.println("  Коммерческий ущерб:   " + ea.getCommercialDamage() + " ¥");
        System.out.println("  Транспорт:            " + ea.getTransportDamage() + " ¥");
        if (ea.getRecoveryEstimateDays() > 0) {
            System.out.println("  Срок восстановления:  " + ea.getRecoveryEstimateDays() + " дней");
        }
        System.out.println("  Страховка:            " + (ea.isInsuranceCovered() ? "Да" : "Нет"));
    }

    private void printCivilianImpact(CivilianImpact ci) {
        if (ci == null) return;
        System.out.println("\nВЛИЯНИЕ НА ГРАЖДАНСКИХ:");
        System.out.println("  Эвакуировано: " + ci.getEvacuated());
        System.out.println("  Ранено:       " + ci.getInjured());
        System.out.println("  Пропало:      " + ci.getMissing());
        System.out.println("  Риск огласки: " + ci.getPublicExposureRisk());
    }

        private void printEnemyActivity(EnemyActivity ea) {
        if (ea == null || (ea.getBehaviorType() == null || ea.getBehaviorType().isEmpty())) {
            return;
        }
        System.out.println("\nАКТИВНОСТЬ ПРОТИВНИКА:");
        System.out.println("  Тип поведения:     " + ea.getBehaviorType());
        System.out.println("  Риск эскалации:    " + ea.getEscalationRisk());
        System.out.println("  Мобильность:       " + ea.getMobility());

        if (!ea.getTargetPriority().isEmpty()) {
            System.out.println("  Приоритет целей:   " + String.join(", ", ea.getTargetPriority()));
        }
        if (!ea.getAttackPatterns().isEmpty()) {
            System.out.println("  Паттерны атаки:");
            for (String pattern : ea.getAttackPatterns()) {
                System.out.println("    • " + pattern);
            }
        }
        if (!ea.getCountermeasuresUsed().isEmpty()) {
            System.out.println("  Принятые меры:");
            for (String measure : ea.getCountermeasuresUsed()) {
                System.out.println("    • " + measure);
            }
        }
    }

    private void printEnvironmentConditions(EnvironmentConditions env) {
        if (env == null) return;
        System.out.println("\nУСЛОВИЯ ОКРУЖЕНИЯ:");
        if (!env.getWeather().isEmpty()) System.out.println("  Погода:            " + env.getWeather());
        if (!env.getTimeOfDay().isEmpty()) System.out.println("  Время суток:       " + env.getTimeOfDay());
        System.out.println("  Видимость:         " + env.getVisibility());
        if (env.getCursedEnergyDensity() > 0) {
            System.out.println("  Плотность проклятой энергии: " + env.getCursedEnergyDensity());
        }
    }

    private void printOperationTimeline(List<OperationTimeline> timeline) {
        if (timeline == null || timeline.isEmpty()) return;
        System.out.println("\nХРОНОЛОГИЯ ОПЕРАЦИИ:");
        for (OperationTimeline t : timeline) {
            System.out.println("  " + t.getTimestamps() + " | " + t.getType() + " | " + t.getDescription());
        }
    }

    private void printStringList(String title, List<String> list) {
        if (list == null || list.isEmpty()) return;
        System.out.println("\n" + title.toUpperCase() + ":");
        for (String item : list) {
            System.out.println("  • " + item);
        }
    }
}
