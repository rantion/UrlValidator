package com.company;



/**
 * Created with IntelliJ IDEA.
 * User: Rachel
 * Date: 10/28/13
 * Time: 8:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class URL {
    private String url, domain, path;

    public URL(String url){
        this.url = url;
        printUrls();
    }

    public void printUrls(){
        System.out.println("URL: "+url.substring(1,url.length()-1));
        setDomain();
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDomain() {
        return domain;
    }

    private void setDomain() {
        String[] tempDomain = url.split("//");
        String fullDomain = tempDomain[1];
        String[]secondSplit = fullDomain.split("/");
        String domain = secondSplit[0];
        System.out.println("Domain: " + domain);
        setPath(secondSplit);


    }

    public String getPath() {
        return path;
    }

    public void setPath(String[] fullDomain) {
        path = "";
        String tempPath = "";
        String pathParts = "";
        if(fullDomain.length<=1){
            path = "not present";
        }
        else if(fullDomain.length>1){
        for(int i = 1; i<fullDomain.length;i++) {
               pathParts = fullDomain[i] + "/";
                tempPath +=pathParts;
            }
            path = tempPath.substring(0,tempPath.length()-2);
        }
        System.out.println("Path: "+path+"\n");
        }
}
