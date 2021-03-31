import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Base64;

public class SHA1 {

	// Esta função gera uma base64 de uma criptografia SHA1.
	public static String gerarHashEntrega(String chCTe, String base64ImagemEntrega) {

		String sha1 = "";
		String hash = chCTe + base64ImagemEntrega;
		String hashEntrega = "";

		try {

			// Gera uma criptografia SHA1 = 20 bytes, 40 caracteres
			MessageDigest digest = MessageDigest.getInstance("SHA-1"); 
			digest.reset();
			digest.update(hash.getBytes("utf8"));

			// Gera uma string Hexadecimal da criptografia SHA1
			sha1 = String.format("%040x", new BigInteger(1, digest.digest())); 

			// Converte a string hexadecimal para um array de bytes
			byte[] b = new BigInteger(sha1, 16).toByteArray();

			// Converte o Array de Bytes para uma base64
			hashEntrega = Base64.getEncoder().encodeToString(b);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		// Retorna a base64 da SHA1
		return hashEntrega;
	}

	// Exemplo de uso da função

	public static void main(String[] argv) {

		String chCTe = "teste"; // Chave do CT-e

		String base64ImagemEntrega = "/outra parte do teste"; // Base64 da imagem capturada da entrega (Exemplo: imagem capturada da assinatura eletrônica, digital do recebedor, foto, etc).

		// Chamada da função.
		String hashGerada = gerarHashEntrega(chCTe, base64ImagemEntrega);

		// Para visualizar a hash para ser informada no campo do evento do CTe
		System.out.println("hash gerada: " + hashGerada); 

	}

}