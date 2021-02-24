package io.github.Samkist;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Decrypt {

    private String toDecrypt;
    private String keyString;
    private Queue<Integer> key;
    private String decrypted;

    public Decrypt(String toDecrypt, String keyString) {
        this.toDecrypt = toDecrypt;
        this.keyString = keyString;
        init();
    }

    public void init() {
        String[] keys = keyString.split(" ");
        key = new Queue<>(Arrays.asList(keys).stream()
                .mapToInt(s -> Integer.parseInt(s)).boxed().collect(Collectors.toList()));
        StringBuffer decryptedBuff = new StringBuffer();
        for(int i = 0; i < toDecrypt.length(); i++) {
            Integer key = this.key.dequeue();
            char toAdd = (char)(toDecrypt.charAt(i) - 32 + 95 - key);
            decryptedBuff.append(toAdd);
            System.out.println(toAdd + " : " + (int) toAdd);
            this.key.enqueue(key);
        }

        decrypted = decryptedBuff.toString();
    }

    public String getDecrypted() {
        return decrypted;
    }

    /*
    FUNCTIONALITY

    - Provide string to decrypt, and key.
    - Iterate through the number of the key string, get their value and add them to the Queue.
    - Subtract 32 from each value.
    - Add 95 to each value.
    - Subtract current key during iteration from each value.
    - Turn number back to character


    Ex: character is 125 + key is 35 = 160, need to mod by 127 leaving 33 left over.

    Apply same key 35 to 33, check if ASCII - 32 is less
     */
}
