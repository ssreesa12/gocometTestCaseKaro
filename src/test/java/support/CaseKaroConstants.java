package support;

public class CaseKaroConstants {
    public static String ButtonMobileCover = "//button[normalize-space()='Mobile Cases & Covers']";
    public static String Search = "//input[@id='search-bar-cover-page']";
    public static String BrandNameLocator = "//button[normalize-space()='%s']";
    public static String ModelNameLocator = "//div[@class='brand-name-main' and text()='%s']";
    public static String ChooseOption = "(//button[contains(normalize-space(),'Choose options')])[1]";
    public static String MaterialsLocator = "//label[normalize-space(text())='%s']";
    public static String AddToCart = "//Span[normalize-space(text())='Add to cart']";
    public static String CloseCart = "//button[@class='drawer__close']";
    public static String Cart = "//a[@id='cart-icon-bubble']";
    public static String MaterialInCart = "//div[@class='product-option']//dd[normalize-space()='%s']";
    public static String CartItemCount = "//tr[@class='cart-item']";
    public static String Material = "//div[@class='product-option'][dt='Material:']/dd";
    public static String Price = "//tr[@class='cart-item']//span[contains(@class,'price')]";
    public static String Link = "//tr[@class='cart-item']//a[contains(@class,'cart-item__name')]";

}
