package data.operation;

public interface IOperation<DST> {
	DST compute(Object...objects);
}	
