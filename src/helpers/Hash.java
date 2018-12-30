package helpers;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.xml.bind.DatatypeConverter;

public class Hash {

	private static final int SALTLENGDE = 32;
	private static final String PASSORD_TEGNSETT = "UTF-8";
	private static final String HASH_ALGORITME = "SHA-256";
	private static final int HASH_ITERATIONS = 1000;

	public static String krypterPassord(String passord) throws IllegalArgumentException {
		if (passord == null || passord.isEmpty()) {
			throw new IllegalArgumentException("Passord er null eller tom streng.");
		}
		byte[] salt = genererTilfeldigSalt();
		return krypterMedSalt(salt, passord);
	}

	public static boolean sjekkPassord(String passord, String kryptert) {
		if (passord == null || passord.isEmpty()) {
			throw new IllegalArgumentException("Passord er null eller tom streng.");
		}
		if (kryptert == null || kryptert.isEmpty()) {
			throw new IllegalArgumentException("Kryptert passord er null eller tom streng.");
		}
		byte[] salt = hentUtSaltFraKryptertStreng(kryptert);
		return krypterMedSalt(salt, passord).equals(kryptert);
	}

	private static byte[] genererTilfeldigSalt() {
		byte[] salt = new byte[SALTLENGDE];
		new SecureRandom().nextBytes(salt);
		return salt;
	}

	private static byte[] hentUtSaltFraKryptertStreng(String kryptert) {
		byte[] saltPlusDigest = DatatypeConverter.parseBase64Binary(kryptert);
		byte[] salt = Arrays.copyOf(saltPlusDigest, SALTLENGDE);
		return salt;
	}

	private static String krypterMedSalt(byte[] salt, String passord) {
		String kryptert = "";
		try {
			byte[] passordBytes = passord.getBytes(PASSORD_TEGNSETT);
			byte[] saltPlusPassord = leggSammen(salt, passordBytes);
			MessageDigest md = MessageDigest.getInstance(HASH_ALGORITME);
			byte[] digest = saltPlusPassord;
			for (int i = 1; i <= HASH_ITERATIONS; i++) {
				digest = md.digest(digest);
			}
			byte[] saltPlusDigest = leggSammen(salt, digest);
			kryptert = DatatypeConverter.printBase64Binary(saltPlusDigest);
		} catch (Exception e) {
			
		}
		return kryptert;

	}

	private static byte[] leggSammen(byte[] tabell1, byte[] tabell2) {
		byte[] enOgTo = new byte[tabell1.length + tabell2.length];
		System.arraycopy(tabell1, 0, enOgTo, 0, tabell1.length);
		System.arraycopy(tabell2, 0, enOgTo, tabell1.length, tabell2.length);
		return enOgTo;
	}
}
