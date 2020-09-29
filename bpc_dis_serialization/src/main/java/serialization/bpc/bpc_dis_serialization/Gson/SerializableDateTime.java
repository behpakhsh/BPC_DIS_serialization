package serialization.bpc.bpc_dis_serialization.Gson;

import java.util.Date;

public class SerializableDateTime extends Date {

    public SerializableDateTime(long readLong) {
        super(readLong);
    }

    public SerializableDateTime(Date date) {
        super(date.getTime());
    }

}