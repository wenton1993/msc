package com.wt.myspringcloud.common.core;

public abstract class BaseRemoteReq {

    // 编码类型：00-GBK 01-GB2312 02-UTF-8，默认为00
    protected String characterSet;
    // 版本号
    protected String version;
    // 公钥
    protected String publicKey;
    // 签名信息
    protected String signInfo;

    public String getCharacterSet() {
        return characterSet;
    }

    public void setCharacterSet(String characterSet) {
        this.characterSet = characterSet;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getSignInfo() {
        return signInfo;
    }

    public void setSignInfo(String signInfo) {
        this.signInfo = signInfo;
    }

}
