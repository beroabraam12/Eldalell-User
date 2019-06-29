package com.project.eldalell.user.Classes;

public class Connection {
    private String UserHostIp = "http://192.168.1.108:5000";
    private String AdminHostIP = "http://192.168.1.108:8000";

    private String SignUpUrl = UserHostIp + "/api/register-user";
    private String LoginUrl = UserHostIp + "/api/login-user";
    private String getAuthUser = UserHostIp + "/api/user-details";
    private String viewCities = AdminHostIP + "/api/cities-view";
    private String getDistrict = AdminHostIP + "/api/district-city/";
    private String getShopType = AdminHostIP + "/api/shoptype-view";
    private String getShopsFromDistrict = AdminHostIP + "/api/shop-district/";
    private String getProductType = AdminHostIP+ "/api/itemcategory-view";
    private String getShopItem = AdminHostIP+ "/api/shopItem-shop/";
    private String getItems = AdminHostIP + "/api/item-itemShop/";
    private String getAddresses = UserHostIp + "/api/user-address/";
    private String getCityFromDistrict = AdminHostIP + "/api/city-district/";
    private String getInvoice = AdminHostIP+"/api/invoiceRow-order/";
    private String AddOrder = AdminHostIP+"/api/orders-add";
    private String AddInvoice = AdminHostIP+"/api/invoicerow-add";
    private String AddAddress = AdminHostIP+"/api/address-add";
    private String UpdateAddress = AdminHostIP+"/api/address-update/";
    private String DeleteAddress = AdminHostIP+"/api/address-delete/";

    public Connection() {
    }


    public String getSignUpUrl() {
        return SignUpUrl;
    }

    public String getLoginUrl() {
        return LoginUrl;
    }

    public String getGetAuthUser() {
        return getAuthUser;
    }

    public String getViewCities() {
        return viewCities;
    }

    public String getGetDistrict() {
        return getDistrict;
    }

    public String getGetShopType() {
        return getShopType;
    }

    public String getGetShopsFromDistrict() {
        return getShopsFromDistrict;
    }

    public String getUserHostIp() {
        return UserHostIp;
    }

    public String getAdminHostIP() {
        return AdminHostIP;
    }

    public String getGetProductType() {
        return getProductType;
    }

    public String getGetShopItem() {
        return getShopItem;
    }

    public String getGetItems() {
        return getItems;
    }

    public String getGetAddresses() {
        return getAddresses;
    }

    public String getGetCityFromDistrict() {
        return getCityFromDistrict;
    }

    public String getGetInvoice() {
        return getInvoice;
    }

    public String getAddOrder() {
        return AddOrder;
    }

    public String getAddInvoice() {
        return AddInvoice;
    }

    public String getAddAddress() {
        return AddAddress;
    }

    public String getUpdateAddress() {
        return UpdateAddress;
    }

    public String getDeleteAddress() {
        return DeleteAddress;
    }
}
