import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class program_cillinlyons_c12505057 extends JFrame implements ActionListener {
	 
    JPanel[] row = new JPanel[5];
    JButton[] button = new JButton[19];

    String[] buttonString = {"7", "8", "9", "+",

                             "4", "5", "6", "-",

                             "1", "2", "3", "*",

                             ".", "/", "C", "√",

                             "Primes", "=", "0"};

    int[] dimW = {800,45,100,90};
    int[] dimH = {35, 40};
	
	//Array list which will contain random numbers
	public static List<Double> list1 = new ArrayList<Double>(); 
	//Array list which will contain prime numbers
	public static List<Double> list2 = new ArrayList<Double>();
	//Array list which will contain random generator numbers
	public static List<Double> list3 = new ArrayList<Double>();

    Dimension displayDimension = new Dimension(dimW[0], dimH[0]);
    Dimension regularDimension = new Dimension(dimW[1], dimH[1]);
    Dimension rColumnDimension = new Dimension(dimW[2], dimH[1]);
    Dimension zeroButDimension = new Dimension(dimW[3], dimH[1]);

    boolean[] function = new boolean[4];
    double[] temporary = {0, 0};
    JTextArea display = new JTextArea(1,20);
    Font font = new Font("Times new Roman", Font.BOLD, 14);

     
    program_cillinlyons_c12505057() {

        super("Calculator");
        setDesign();
        setSize(1500, 400);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(5,5);
        setLayout(grid);

         
        for(int i = 0; i < 4; i++)
            function[i] = false;
         
        FlowLayout f1 = new FlowLayout(FlowLayout.CENTER);
        FlowLayout f2 = new FlowLayout(FlowLayout.CENTER,1,1);

        for(int i = 0; i < 5; i++)
            row[i] = new JPanel();
			row[0].setLayout(f1);

        for(int i = 1; i < 5; i++)
            row[i].setLayout(f2);

        for(int i = 0; i < 19; i++) {

            button[i] = new JButton();
            button[i].setText(buttonString[i]);
            button[i].setFont(font);
            button[i].addActionListener(this);
        }

         
        display.setFont(font);
        display.setEditable(false);
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        display.setPreferredSize(displayDimension);

        for(int i = 0; i < 14; i++)
            button[i].setPreferredSize(regularDimension);
        for(int i = 14; i < 18; i++)
            button[i].setPreferredSize(rColumnDimension);
        button[18].setPreferredSize(zeroButDimension);
         
        row[0].add(display);

        add(row[0]);

         
        for(int i = 0; i < 4; i++)

        row[1].add(button[i]);
        row[1].add(button[14]);
        add(row[1]);

         
        for(int i = 4; i < 8; i++)

        row[2].add(button[i]);
        row[2].add(button[15]);
        add(row[2]);

         
        for(int i = 8; i < 12; i++)

        row[3].add(button[i]);
        row[3].add(button[16]);
        add(row[3]);
        row[4].add(button[18]);
		
        for(int i = 12; i < 14; i++)

        row[4].add(button[i]);
        row[4].add(button[17]);
        add(row[4]);

        setVisible(true);
    }

		public void random_list() 
		{ 
			String newline = System.getProperty("line.separator");
			display.setSize(2000,500);
			display.setText("");
			//Adding list of random prime numbers to rand_list1
			String rand_list1 = String.valueOf(list1);
			//Adding list of next prime nums to rand_list2
			String rand_list2 = String.valueOf(list2);
			String rand_list = "Prime Numbers: " + rand_list1 + newline + "Next Primes Numbers: " + rand_list2;
			//Displaying both list
			display.setText(rand_list);
		}
     
	 public void java_rand() 
		{ 
			String newline = System.getProperty("line.separator");
			display.setSize(2000,500);
			display.setText("");
			String rand_list3 = String.valueOf(list3);
			display.setText(rand_list3);
		}
    public void clear() {

        try {

            display.setText("");
            for(int i = 0; i < 4; i++)
                function[i] = false;
            for(int i = 0; i < 2; i++)
                temporary[i] = 0;

        } catch(NullPointerException e) { 

        }
		
    }

    public void getSqrt() {

        try {

            double value = Math.sqrt(Double.parseDouble(display.getText()));
            display.setText(Double.toString(value));

        } catch(NumberFormatException e) {

        }

    }
	
    public void getPosNeg() {

        try {

            double value = Double.parseDouble(display.getText());
            if(value != 0) {
                value = value * (-1);
                display.setText(Double.toString(value));
            }

            else {

            }

        } catch(NumberFormatException e) {

        }

    }

     
    public void getResult() {

        double result = 0;
        temporary[1] = Double.parseDouble(display.getText());
        String temp0 = Double.toString(temporary[0]);
        String temp1 = Double.toString(temporary[1]);

        try {

            if(temp0.contains("-")) {
                String[] temp00 = temp0.split("-", 2);
                temporary[0] = (Double.parseDouble(temp00[1]) * -1);

            }

            if(temp1.contains("-")) {
                String[] temp11 = temp1.split("-", 2);
                temporary[1] = (Double.parseDouble(temp11[1]) * -1);

            }

        } catch(ArrayIndexOutOfBoundsException e) {

        }

        try {

            if(function[2] == true)
                result = temporary[0] * temporary[1];
            else if(function[3] == true)
                result = temporary[0] / temporary[1];
            else if(function[0] == true)
                result = temporary[0] + temporary[1];
            else if(function[1] == true)
                result = temporary[0] - temporary[1];

            display.setText(Double.toString(result));
            for(int i = 0; i < 4; i++)
                function[i] = false;

        } catch(NumberFormatException e) {

        }
    }

    public final void setDesign() {

        try {

            UIManager.setLookAndFeel(

                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e) {  

        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == button[0])
            display.append("7");

        if(ae.getSource() == button[1])
            display.append("8");

        if(ae.getSource() == button[2])
            display.append("9");

        if(ae.getSource() == button[3]) {

            //add function[0]
            temporary[0] = Double.parseDouble(display.getText());
            function[0] = true;
            display.setText("");
        }

        if(ae.getSource() == button[4])
            display.append("4");

        if(ae.getSource() == button[5])
            display.append("5");

        if(ae.getSource() == button[6])
            display.append("6");

        if(ae.getSource() == button[7]) {
            //subtract function[1]
            temporary[0] = Double.parseDouble(display.getText());
            function[1] = true;
            display.setText("");
        }

        if(ae.getSource() == button[8])
            display.append("1");

        if(ae.getSource() == button[9])
            display.append("2");

        if(ae.getSource() == button[10])
            display.append("3");

        if(ae.getSource() == button[11]) {
            //multiply function[2]
            temporary[0] = Double.parseDouble(display.getText());
            function[2] = true;
            display.setText("");
        }

        if(ae.getSource() == button[12])
            display.append(".");
		
        if(ae.getSource() == button[13]) {
            //divide function[3]
            temporary[0] = Double.parseDouble(display.getText());
            function[3] = true;
            display.setText("");
        }

        if(ae.getSource() == button[14])
            clear();

        if(ae.getSource() == button[15])
            java_rand();

        if(ae.getSource() == button[16])
            random_list();

        if(ae.getSource() == button[17])
            getResult();

        if(ae.getSource() == button[18])
            display.append("0");

    }
	
		// pre-compute a few values
        private static final BigInteger two = BigInteger.valueOf(2L);
        private static final BigInteger three = BigInteger.valueOf(3L);
        private static final BigInteger four = BigInteger.valueOf(4L);

        /**
         * main parameter
         */
        private BigInteger n;
        private BigInteger state;

        /**
         * Generate appropriate prime number for use in Blum-Blum-Shub.
         * 
         * This generates the appropriate primes (p = 3 mod 4) needed to compute the
         * "n-value" for Blum-Blum-Shub.
         * 
         * @param bits Number of bits in prime
         * @param rand A source of randomness
         */
        private static BigInteger getPrime(int bits, Random rand) {
                BigInteger p;
                while (true) {
                        p = new BigInteger(bits, 100, rand);
                        if (p.mod(four).equals(three))
                                break;
                }
                return p;
        }

        /**
         * This generates the "n value" -- the multiplication of two equally sized
         * random prime numbers -- for use in the Blum-Blum-Shub algorithm.
         * 
         * @param bits
         *            The number of bits of security
         * @param rand
         *            A random instance to aid in generating primes
         * @return A BigInteger, the <i>n</i>.
         */
        public static BigInteger generateN(int bits, Random rand) {
                BigInteger p = getPrime(bits/2, rand);
                BigInteger q = getPrime(bits/2, rand);
                
                while (p.equals(q)) {
                        q = getPrime(bits, rand);
                }
                return p.multiply(q);
        }

        /**
         * Constructor, specifing bits for <i>n</i>
         * 
         * @param bits number of bits
         */
        public program_cillinlyons_c12505057(int bits) {
                this(bits, new Random());
        }
        
        /**
         * Constructor, generates prime and seed
         * 
         * @param bits
         * @param rand
         */
        public program_cillinlyons_c12505057(int bits, Random rand) {
                this(generateN(bits, rand));
        }
        
        /**
         * A constructor to specify the "n-value" to the Blum-Blum-Shub algorithm.
         * The inital seed is computed using Java's internal "true" random number
         * generator.
         * 
         * @param n
         *            The n-value.
         */
        public program_cillinlyons_c12505057(BigInteger n) {
                this(n, SecureRandom.getSeed(n.bitLength() / 8));
        }

        /**
         * A constructor to specify both the n-value and the seed to the
         * Blum-Blum-Shub algorithm.
         * 
         * @param n
         *            The n-value using a BigInteger
         * @param seed
         *            The seed value using a byte[] array.
         */
        public program_cillinlyons_c12505057(BigInteger n, byte[] seed) {
                this.n = n;
                setSeed(seed);
        }

        /**
         * Sets or resets the seed value and internal state
         * 
         * @param seedBytes
         *            The new seed.
         */
        public void setSeed(byte[] seedBytes) {
                // ADD: use hardwired default for n
                BigInteger seed = new BigInteger(1, seedBytes);
                state = seed.mod(n);
        }

        /**
         * Returns up to numBit random bits
         * 
         * @return int
         */
        public int next(int numBits) {
                // TODO: find out how many LSB one can extract per cycle.
                //   it is more than one.
                int result = 0;
                for (int i = numBits; i != 0; --i) {
                        state = state.modPow(two, n);
                        result = (result << 1) | (state.testBit(0) == true ? 1 : 0);
                }
                return result;
		}
		
	public Double LCG()
	{
		// creating a random seed
		BigInteger num = new BigInteger(17, new Random(){}); 
		BigInteger m = new BigInteger("65535");//2^16
        Random ran = new Random();
		StringBuilder strb = new StringBuilder();
 
		//Binding random numbers into strb
        for(int i=0; i<1; i++)
        {
            BigInteger x = new BigInteger(17, new Random(){});
            BigInteger y = new BigInteger(17, new Random(){});
            num = ((x.multiply(x)).add(y)).mod(m);
			strb.append(num);
        }
		
		String strb2 = strb.toString(); 
		//Convert strb string to a double
		Double bbsran= Double.parseDouble(strb2);
		return bbsran;
	}
	
	//Check if numebr is prime
	public static boolean isPrime(double n) 
	{
    //check if n is a multiple of 2
    if (n%2==0) return false;
    //if not, then just check the odds
    for(double i=3;i*i<=n;i+=2) 
	{
        if(n%i==0)
            return false;
    }
    return true;
	}
	
	//Returns next prime number of numbers entered by user
	public static Double nextPrime(Double num) 
	{
		num = num +1;
		
		for (int a=1;a<100;a++)
		{
			if (isPrime(num) == false)
			{
				num = num + 1;
			}
		}
		return num;
	}
		     
    public static void main(String[] arguments) {

				program_cillinlyons_c12505057 swing = new program_cillinlyons_c12505057();
				boolean result;
				int x;
				Double y,z;
				List<Double> algorithm_nums = new ArrayList<Double>();
				List<Double> prime_nums = new ArrayList<Double>();
				List<Double> rand_nums = new ArrayList<Double>();
				
		
				// First use the internal, stock "true" random number
                // generator to get a "true random seed"
                SecureRandom r = new SecureRandom();
                r.nextInt(); // need to do something for SR to be triggered.

                // Use this seed to generate a n-value for Blum-Blum-Shub
                // This value can be re-used if desired.
                int bitsize = 512;
                BigInteger nval = program_cillinlyons_c12505057.generateN(bitsize, r);
                
                // now get a seed
                byte[] seed = new byte[bitsize/8];
                r.nextBytes(seed);

                // now create an instance of BlumBlumShub
                program_cillinlyons_c12505057 bbs = new program_cillinlyons_c12505057(nval, seed);
				
			//Generate random numbers
			for (int j=1;j<1000;j++)
			{ 
				if(algorithm_nums.size() < 10)
				{ 
					x = bbs.next(20); 
					if(x<1)
					{
						//No negative numbers
						x = Math.abs(x); 
					}
					Integer int1 = new Integer(x);
					double a = int1.doubleValue();
					result = bbs.isPrime(a); 
					if (result == true)
					{ 
						//Add prime numbers to rand_nums list
						algorithm_nums.add(a);
					}
				}
			}
              
			//Generate random numbers
            for (int i=1;i<1000;i++)
			{ 
				if(algorithm_nums.size() < 5)
				{ 
					y = bbs.LCG(); 
					if(y<1)
					{
						//No negative numbers
						y = Math.abs(y); 
					}
					result = bbs.isPrime(y); 
					if (result == true)
					{ 
						//Add prime numbers to rand_nums list
						algorithm_nums.add(y);
					}
					algorithm_nums.add(y);
				}
			}
		
		//Find next random numbers of prime number list
		for(int k=0;k<algorithm_nums.size();k++)
		{ 
			Double num = algorithm_nums.get(k);
			z = bbs.nextPrime(num);
			//Add these next prime numbers to prime_nums list
			prime_nums.add(z);
		} 
        
		//Add these lists to the global list declared at the start of the program
		list1.addAll(algorithm_nums); 
		list2.addAll(prime_nums);
		
		Random diceRoller = new Random();
		double roll;
		for (int i = 0; i < 10; i++) 
		{
			roll = diceRoller.nextInt(1000) ;
			rand_nums.add(roll);
		}
		list3.addAll(rand_nums);
	}
}
