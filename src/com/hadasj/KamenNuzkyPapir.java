package com.hadasj;

import java.util.Random;

public class KamenNuzkyPapir {
	private static final String VYHRA = "Vyhrál jsi! Gratuluji. :-)";
	private static final String PROHRA = "Prohrál jsi. Je mi líto. :-(";
	private static final String REMIZA = "Nerozhodně. :-/";

	public enum Volba {
		KAMEN(1),
		NUZKY(2),
		PAPIR(3);

		private final int poradi;

		Volba(int poradi) {
			this.poradi = poradi;
		}

		static Volba poradi(int poradi) {
			for (Volba volba : values()) {
				if (volba.poradi == poradi) {
					return volba;
				}
			}
			throw new IllegalArgumentException("Necekane poradi " + poradi);
		}
	}

	private Volba pocitac;
	private Volba clovek;

	public void setUp(final int clovek) throws IllegalArgumentException{
		final var random = new Random();
		pocitac = Volba.poradi(random.nextInt(1, 3));
		this.clovek = Volba.poradi(clovek);
	}

	public static String popisHry() {
		var text = "Hra kámen nůžky papír:\n";
		for (Volba volba : Volba.values()) {
			text += volba.name() + ": " + volba.poradi + "\n";
		}
		text += "Tvoje volba (cislo 1 .. 3): ";
		return text;
	}

	public String eval() {
		return "Vybral sis " + clovek.name() + " a pocitac zvolil " + pocitac.name() + "\n" + switch (clovek) {
			case KAMEN -> switch (pocitac) {
				case PAPIR -> PROHRA;
				case NUZKY -> VYHRA;
				default -> REMIZA;
			};
			case NUZKY -> switch (pocitac) {
				case PAPIR -> VYHRA;
				case KAMEN -> PROHRA;
				default -> REMIZA;
			};
			case PAPIR -> switch (pocitac) {
				case KAMEN -> VYHRA;
				case NUZKY -> PROHRA;
				default -> REMIZA;
			};
		};
	}
}
