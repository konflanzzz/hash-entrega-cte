import javax.xml.bind.DatatypeConverter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class SHA1 {

    // Esta função gera uma base64 de uma criptografia SHA1.
    public static String gerarHashEntrega(String chCTe, String base64ImagemEntrega) {

        String sha1 = "";
        String hash = chCTe + base64ImagemEntrega;
        String hashEntrega = "";

        try {

            // Gera uma criptografia SHA1 = 20 bytes, 40 caracteres
            MessageDigest digest = MessageDigest.getInstance("sha-1");
            digest.reset();
            digest.update(hash.getBytes(StandardCharsets.UTF_8));

            // Gera uma string Hexadecimal da criptografia SHA1
            sha1 = String.format("%040x", new BigInteger(1, digest.digest()));

            // Converte a string hexadecimal para um array de bytes
            byte[] b = DatatypeConverter.parseHexBinary(sha1);

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
	    
	    // Chave do CT-e
        String chCTe = ""; 
	
	    // Base64 da imagem capturada da entrega (Exemplo: imagem capturada da assinatura eletrônica, digital do recebedor, foto, etc).    
        String base64ImagemEntrega = ""; 

        // Chamada da função.
        String hashGerada = gerarHashEntrega(chCTe, base64ImagemEntrega);

        // Para visualizar a hash para ser informada no campo do evento do CTe
        System.out.println("hashEntrega : " + hashGerada);

    }

}
