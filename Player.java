import java.util.Scanner;

public class Player
{
    final int[] numbers=new int[5];
    final String[] flowers =new String[5];
    private int grade=0;

    public Player()
    {
        Scanner in=new Scanner(System.in);
        String infor=in.next();
        stringToNumber(infor.substring(0,1),0);
        flowers[0]=infor.substring(1,2);
        infor=in.next();
        stringToNumber(infor.substring(0,1),1);
        flowers[1]=infor.substring(1,2);
        infor=in.next();
        stringToNumber(infor.substring(0,1),2);
        flowers[2]=infor.substring(1,2);
        infor=in.next();
        stringToNumber(infor.substring(0,1),3);
        flowers[3]=infor.substring(1,2);
        infor=in.next();
        stringToNumber(infor.substring(0,1),4);
        flowers[4]=infor.substring(1,2);
        pair();
        doublePair();
        three();
        straight();
        sameFlowers();
        straightAndSameFlowers();;
    }

    public int getGrade()
    {
        return grade;
    }

    public void stringToNumber(String s,int index)
    {
        switch(s)
        {
            case("2"):
                numbers[index]=2;
                break;
            case("3"):
                numbers[index]=3;
                break;
            case("4"):
                numbers[index]=4;
                break;
            case("5"):
                numbers[index]=5;
                break;
            case("6"):
                numbers[index]=6;
                break;
            case("7"):
                numbers[index]=7;
                break;
            case("8"):
                numbers[index]=8;
                break;
            case("9"):
                numbers[index]=9;
                break;
            case("T"):
                numbers[index]=10;
                break;
            case("J"):
                numbers[index]=11;
                break;
            case("Q"):
                numbers[index]=12;
                break;
            case("K"):
                numbers[index]=13;
                break;
            case("A"):
                numbers[index]=14;
                break;
        }
    }

    public void pair()
    {
        for(int i=0;i<4;++i)
        {
            for(int j=i+1;j<5;++j)
            {
                if(numbers[i]==numbers[j])
                {
                    grade=1;
                    break;
                }
            }
        }
    }

    public void doublePair()
    {
        int sum=0;
        for(int i=0;i<4;++i)
        {
            for(int j=i+1;j<5;++j)
            {
                if(numbers[i]==numbers[j])
                {
                    ++sum;
                }
            }
        }
        if(sum==2)grade=2;
    }

    public void three()
    {
        int i=0,j=i+1;
        boolean a=false;
        for(;i<4;++i)
        {
            for(;j<5;++j)
            {
                if(numbers[i]==numbers[j])
                {
                    a=true;
                    break;
                }
            }
            if(a)break;
        }
        if(a)
        {
            ++j;
            for(;j<5;++j)
            {
                if(numbers[i]==numbers[j])
                {
                    grade=3;
                }
            }
        }
    }

    public boolean straight()
    {
        for(int i=0;i<4;++i)
        {
            int min=i;
            for(int j=i+1;j<5;++j)
            {
                if(numbers[min]>numbers[j])
                {
                    min=j;
                }
            }
            if(min!=i)
            {
                int t=numbers[min];
                numbers[min]=numbers[i];
                numbers[i]=t;
            }
        }
/*        for(int i=0;i<5;++i)
        {
            System.out.println(numbers[i]);
        }*/
        for(int i=0;i<4;++i)
        {
            int j=i+1;
            if(numbers[j]-numbers[i]==1)
            {
                grade=4;
                return true;
            }
        }
        return false;
    }

    public boolean sameFlowers()
    {
        if(flowers[0].equals(flowers[1])&&flowers[0].equals(flowers[2])&&flowers[0].equals(flowers[3])&&flowers[0].equals(flowers[4]))
        {
            grade=5;
            return true;
        }
        return false;
    }

    public void straightAndSameFlowers()
    {
        if(straight()&&sameFlowers())
        {
            grade=6;
        }
    }
}
