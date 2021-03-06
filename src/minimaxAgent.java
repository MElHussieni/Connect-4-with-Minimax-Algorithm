import java.util.ArrayList;

class minimaxAgent{
	
	int depth;
	int x=0;
	
	public minimaxAgent(int depth)
	{
		this.depth = depth;
	}	
	
	
	public int getAction(State st) throws CloneNotSupportedException
	{
		double val = max_value(st, depth);
		//return max_value(st, depth);
		return x;
		
	}
	
	
	public double max_value(State st, int d) throws CloneNotSupportedException
	{
		ArrayList<Integer> children = new ArrayList<Integer>();
		if(d == 0)
		return st.evaluationFunction();
		else
		{
		children = st.getLegalActions();
		double v = -10000000;
		
		double z;
		//double z;
		for(int i =0; i<children.size();i++)
		{
			z = min_value(st.generateSuccessor('O',children.get(i)),d);
			if(z >= v)
			{
				v =z;
				this.x = i;
			}
		}
		//System.out.println("x: "+this.x);
		return v;
		}
	}
	
	
	public double min_value(State st, int d) throws CloneNotSupportedException
	{
		
		ArrayList<Integer> children = new ArrayList<Integer>();
		if(d == 0)
		return st.evaluationFunction();
		else
		{
		children = st.getLegalActions();
		
		double v = 10000000;
		int x=0;
		double z;
		for(int i =0; i<children.size();i++)
		{
			z= max_value(st.generateSuccessor('X',children.get(i)),d-1);
			if(z <= v)
				v=z;
		
		}
		return v;
		}
	}
	
	
	
}
