package Application.DSA;

import java.util.Set;
import java.util.TreeSet;

public class ParanthesisPermutation {

    Set<String> parans = new TreeSet<>();

    private char left = '(';
    private char right = ')';

    public static void main(String[] args) {
        ParanthesisPermutation p = new ParanthesisPermutation();

        p.permute(3);

        System.out.println(p.parans);
    }

    private Set<String> permute(int n) {

        StringBuffer sb = new StringBuffer();

        if(1 == n){
             parans.add(sb.append(left).append(right).toString());
             return parans;
        }

        parans = permute(n-1);

            parans.stream().forEach(s -> {
                parans.add(sb.append(left).append(right).append(permute(n-1)).toString());
                parans.add(sb.append(left).append(permute(n-1)).append(right).toString());
            });
            return parans;




    }

}
