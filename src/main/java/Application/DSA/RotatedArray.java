package Application.DSA;

public class RotatedArray {


    public int search(int[] input, int element) {

        if(null == input)
            return -1;

        return search(input, element, 0,input.length-1);
    }

    private int search(int[] input, int element, int start, int end) {

        int mid = start+ (end-start)/2;

        if(input[mid] == element)
            return mid;
        if(input[start] == element)
            return start;
        if(input[end] == element)
            return end;

        if(input[mid] < element){
            if(input[end] < element  || input[start] < input[mid])
               return search(input,element, start, mid);
            else if(input[end] > element  || input[end] > input[mid])
                return  search(input,element, mid+1, end);
        }else{
            if(input[start] < element || input[start] > input[mid])
                return search(input,element, start, mid);
            else if(input[start] > element || input[end] < input[mid])
                return search(input,element, mid+1, end);
        }


        return -1;
    }
}
