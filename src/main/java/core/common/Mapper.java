package core.common;

public interface Mapper<From, To> {

    To mapFrom(From obj);

    From mapTo(To obj);

}
