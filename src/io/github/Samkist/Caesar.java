package io.github.Samkist;

public class Caesar {

    public static void main(String[] args) {
        String encrypted = new Encrypt("Uh oh stinky!", "11 12 45").getEncrypted();
        System.out.println(encrypted);
        System.out.println(new Decrypt(encrypted, "11 12 45").getDecrypted());
    }
}
