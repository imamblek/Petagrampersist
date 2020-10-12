package com.imamblek.petagram.restApi;

public class ConstantesRestApi {
    //https://graph.facebook.com/v8.0/
    public static final String VERSION = "/v8.0/";
    public static final String ROOT_URL = "https://graph.facebook.com" + VERSION;
    public static final String ACCESS_TOKEN = "EAAMz6ZAst5FYBAOs7jKSdNd0fSfZC2WSZCm0I1awNqvtfCxW22QKTlb1hJFkSMuXhGAlrwJk4VnT68DFR5kfqQAZBI49xAhIa7fiayYRXrarR7Psky4MVbKORLyED2HUJmJkdaXEzMYCsG5a76XdQhY8wrab2ZADZBlIUxsWV8NwZDZD";
    //https://graph.facebook.com/v8.0/17841443195719854/media?fields=id,media_type,media_url,like_count,owner,timestamp&access_token=EAAMz6ZAst5FYBAOs7jKSdNd0fSfZC2WSZCm0I1awNqvtfCxW22QKTlb1hJFkSMuXhGAlrwJk4VnT68DFR5kfqQAZBI49xAhIa7fiayYRXrarR7Psky4MVbKORLyED2HUJmJkdaXEzMYCsG5a76XdQhY8wrab2ZADZBlIUxsWV8NwZDZD
    public static final String KEY_ACCESS_TOKEN = "&access_token=";
    // obtener las fotos
    //https://graph.facebook.com/v8.0/17841443195719854/media?fields=media_url&access_token=EAAMz6ZAst5FYBAOs7jKSdNd0fSfZC2WSZCm0I1awNqvtfCxW22QKTlb1hJFkSMuXhGAlrwJk4VnT68DFR5kfqQAZBI49xAhIa7fiayYRXrarR7Psky4MVbKORLyED2HUJmJkdaXEzMYCsG5a76XdQhY8wrab2ZADZBlIUxsWV8NwZDZD
    public static final String KEY_GET_MEDIA_USER = "17841443195719854/media?fields=media_url";
    public static final String URL_GET_MEDIA_USER = KEY_GET_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;


}
