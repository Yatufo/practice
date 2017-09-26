package interviewbit.stack;

import java.util.Stack;

public class SimplifyDirectoryPath {

    public static void main(String[] args){
        new SimplifyDirectoryPath().solve("/../");
    }

    public String solve(String path) {
        String separator = "/";
        String[] directories = path.split(separator) ;
        Stack<String> dirpile = new Stack<>();
        for(String directory : directories){
            switch (directory){
                case "." : break;
                case "" : break;
                case "..":
                    if(!dirpile.isEmpty()){
                        dirpile.pop();
                    }
                    break;
                default:
                    dirpile.push(directory);
                    break;

            }
        }

        StringBuilder builder = new StringBuilder();
        if (dirpile.isEmpty()) {
            builder.append(separator);
        } else{
            for (Object d : dirpile.toArray()) {
                builder.append(separator).append(d.toString());
            }
        }

        return builder.toString();
    }


}
