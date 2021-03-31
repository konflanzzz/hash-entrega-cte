import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Base64;

public class SHA1 {

	public static void main(String[] argv){
		
		String chCTe = ""; 
		String imagemEntrega = ""; // Base64 da imagem capturada da entrega (Exemplo: imagem capturada da assinatura eletrônica, digital do recebedor, foto, etc)
		String sha1 = "";
		String hashComprovante = chCTe + imagemEntrega;
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
	        digest.reset();
	        digest.update(hashComprovante.getBytes("utf8"));
	        sha1 = String.format("%040x", new BigInteger(1, digest.digest()));

		} catch (Exception e){
			e.printStackTrace();
		}

		byte[] b = new BigInteger(sha1, 16).toByteArray();
		String hashEntrega = Base64.getEncoder().encodeToString(b);


		//System.out.println("hash sha1: " + sha1);
		//System.out.println("bytes da hash sha1: " + b);
		System.out.println("hash gerada: " + hashEntrega); // hash para ser informada no campo do evento do CTe

     }
}