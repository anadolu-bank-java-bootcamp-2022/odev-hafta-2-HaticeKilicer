package com.gokhantamkoc.javabootcamp.odevhafta2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlayWorldOfMagic implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(PlayWorldOfMagic.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		int maxNumOfAttacksAllowed = 9;
		String[] magicianSpells = createSpellNameRepository();
		float[] spellDamageInfo = createSpellDamageRepository();
		String[] bossNames = createBossNameRepository();
		float[] bossHps = createBossHPRepository();

		int minNumberSpellsUsed = resolveBattle(magicianSpells, spellDamageInfo, bossNames, bossHps);

		if (minNumberSpellsUsed > maxNumOfAttacksAllowed) {
			System.out.println("Magician died!");
		} else if (minNumberSpellsUsed > 0 && minNumberSpellsUsed <= maxNumOfAttacksAllowed) {
			System.out.println("Magician won the battle!");
		} else {
			System.out.println("Result is not correct!");
		}
	}

	public static int resolveBattle(String[] magicianSpells, float[] spellDamageInfo, String[] bossNames,
			float[] bossHPs) {

		int spellsUsed = 0;
		// ______ BASLANGIC _______ Kodunuz buradan baslamali

		// ______ SON _______ Kodunuz burada bitmeli
		/*
		 * NOT: ______ BASLANGIC _______ ve ______ SON _______ arasina istediginiz kadar
		 * sayida satir ekleyebilirsiniz.
		 */

		// find max damage
		float maxDamage = 0;
		for (int index = 0; index < spellDamageInfo.length; index++) {
			if (spellDamageInfo[index] > maxDamage)
				maxDamage = spellDamageInfo[index];
		}

		System.out.println("maxDamage: " + maxDamage);

		// spell count
		int spellCount = 0;
		float remHPs = 0f; // remainder HPs

		for (int index = 0; index < bossHPs.length; index++) {
			remHPs = bossHPs[index];
			while ((int) remHPs > 0) {

				remHPs = remHPs - maxDamage;
				spellCount++;
			}
		}
		return spellsUsed = spellCount;
	}

	public static String[] createSpellNameRepository() {
		return new String[] { "Ice Storm", "Chain Lightning", "Magic Missile" };
	}

	public static float[] createSpellDamageRepository() {
		return new float[] { 40.0f, 30.0f, 5.0f };
	}

	public static String[] createBossNameRepository() {
		return new String[] { "Dire Rat", "Skeleton Knight", "Undead King" };
	}

	public static float[] createBossHPRepository() {
		return new float[] { 15.0f, 45.0f, 60.0f };
	}
}
