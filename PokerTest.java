public class PokerTest
{
    public static void main(String[] args)
    {
        System.out.print("Black:");
        Player p1=new Player();
        System.out.print("White:");
        Player p2=new Player();
        if(p1.getGrade()>p2.getGrade())
        {
            System.out.println("Black wins");
        }
        else if(p1.getGrade()<p2.getGrade())
        {
            System.out.println("White wins");
        }
        else
        {
            boolean end=false;
            for(int i=4;i>=0;--i)
            {
                if(p1.numbers[i]>p2.numbers[i])
                {
                    System.out.println("Black wins");
                    end=true;
                    break;
                }
                else if(p1.numbers[i]<p2.numbers[i])
                {
                    System.out.println("White wins");
                    end=true;
                    break;
                }
            }
            if(!end)
            {
                System.out.println("Tie");
            }
        }
    }
}
