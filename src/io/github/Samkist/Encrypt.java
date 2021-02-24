package io.github.Samkist;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
//import java.util.Queue;

public class Encrypt {

    private String toEncrypt;
    private String keyString;
    private Queue<Integer> key;
    private String encrypted;

    public Encrypt(String toEncrypt, String keyString) {
        this.toEncrypt = toEncrypt;
        this.keyString = keyString;
        init();
    }

    private void init() {
        String[] keys = keyString.split(" ");
        key = new Queue<>(Arrays.asList(keys).stream()
                .mapToInt(s -> Integer.parseInt(s)).boxed().collect(Collectors.toList()));
        StringBuffer encryptedBuff = new StringBuffer();
        for(int i = 0; i < toEncrypt.length(); i++) {
            Integer key = this.key.dequeue();
            char toAdd = (char)((key + toEncrypt.charAt(i) + 32) % 95);
            encryptedBuff.append(toAdd);
            System.out.println("Character: " + toEncrypt.charAt(i) + " ASCII: " + (int) toEncrypt.charAt(i) + " Key: " + key);
            this.key.enqueue(key);
        }

        encrypted = encryptedBuff.toString();
    }

    public String getEncrypted() {
        return encrypted;
    }


    /*
    FUNCTIONALITY

    !! CAN ONLY USE INDEX 32 OR ABOVE !!

    - Provide a string to encrypt and a string of numbers split by a space in the key
    - Iterate through the number of the key string, get their value and add them to the Queue.
    - Loop through the key queue,
        add the number currently in the front of the queue to the ASCII value of the current character in the string
    - % it by 95, and then add 32
    - Append to string buffer for resulting output.
    - Return



     */
}
