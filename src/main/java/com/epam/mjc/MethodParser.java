package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        //throw new UnsupportedOperationException("You should implement this method.");
        List<String> l1 = new ArrayList<>();
        StringTokenizer st1 = new StringTokenizer(signatureString, " ");
        while(st1.hasMoreTokens()){
            l1.add(st1.nextToken());
        }

        List<String> l2 = new ArrayList<>();
        StringTokenizer st2 = new StringTokenizer(l1.get(3), "(,)");
        while(st2.hasMoreTokens()){
            l2.add(st2.nextToken());
        }
        List<MethodSignature.Argument> argList = new ArrayList<>();

        StringTokenizer st3 = new StringTokenizer(l2.toString(), " ");
        while(st3.hasMoreTokens()){
            l2.add(st3.nextToken());
            String type = st3.nextToken();
            String name = st3.nextToken();
            MethodSignature.Argument arg = new MethodSignature.Argument(type, name);
            argList.add(arg);
        }

        MethodSignature mg = new MethodSignature(l1.get(2), argList);
        mg.setAccessModifier(l1.get(0));
        mg.setReturnType(l1.get(1));
        return mg;

    }
}
