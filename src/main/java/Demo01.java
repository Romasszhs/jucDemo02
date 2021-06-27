public class Demo01 {
    public static void main(String[] args) {
        String str = "zhongweb";
        String[] gs = str.split("g");
        System.out.println(gs[0]+","+gs[1]);

        int a =1 ;
        int b=1;
        for (int c=0;c<5;c++){
            if ((++a>2)&(++b>2)){
                a++;
                System.out.println("a="+a+"b="+b+"c="+c);
            }else{
                System.out.println("a="+a+"b="+b+"c="+c);
            }
        }
        System.out.println("a="+a+"b="+b);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
