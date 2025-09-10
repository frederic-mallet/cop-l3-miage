package data.operation;

public interface IMap<SRC, DST> { 
	DST map(SRC src);
}
