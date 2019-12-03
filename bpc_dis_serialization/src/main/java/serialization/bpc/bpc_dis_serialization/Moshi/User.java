package serialization.bpc.bpc_dis_serialization.Moshi;

import com.squareup.moshi.Json;

public class User {

    @Json(name = "name") private String name;
    @Json(name = "family") private String family;

}
