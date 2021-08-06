package com.fm.newsProject.services.utilities.errors;

public class ErrorMessages {
    // News Errors
    public static String getNewsTitleNullError() {
        return "Haber Başlığı Boş Geçilemez.";
    }

    public static String getNewsTitleLengthSmallerThan6(){
        return "Haber Başlığı En Az 6 Karakter Olmalıdır.";
    }

    // Category Errors
    public static String getCategoryNameNullError() {return "Kategori Adı Boş Geçilemez.";}

    public static String getCategoryNameLengthSmallerThan2() {return "Kategori Adı En Az 2 Karakter Olmalıdır.";}

    // Writer Errors
    public static String getWriterFirstNameNullError() {return "Yazar Adı Boş Geçilemez.";}

    public static String getWriterFirstNameLengthSmallerThan3() {return "Yazar Adı En Az 3 Karakter Olmalıdır.";}

    public static String getWriterLastNameNullError() {return "Yazar Soyadı Boş Geçilemez.";}

    public static String getWriterLastNameLengthSmallerThan3() {return "Yazar Soyadı En Az 3 Karakter Olmalıdır.";}

    public static String getWriterEmailNullError() {return "Yazar E-Postası Boş Geçilemez.";}

    public static String getWriterEmailIsInvalidError() {return "Yazar E-Postası E-Posta Formatında Olmalıdır.";}
}
