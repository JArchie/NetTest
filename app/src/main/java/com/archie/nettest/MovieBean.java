package com.archie.nettest;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jarchie on 2017\11\7.
 * 描述：猫眼电影首页数据实体
 */

@SuppressWarnings("unused")
public class MovieBean {

    /**
     * control : {"expires":1800}
     * status : 0
     * data : {"hasNext":true,"movies":[{"late":false,"cnms":0,"sn":0,"showInfo":"今天133家影院放映2517场","wish":218426,"3d":true,"src":"","showDate":"","img":"http://p1.meituan.net/165.220/movie/579a0919e926a80ad14c717c8d8a8394259181.jpg","nm":"雷神3：诸神黄昏","sc":8.9,"ver":"3D/IMAX 3D/中国巨幕/全景声","rt":"2017-11-03上映","preSale":0,"vd":"","dir":"塔伊加·维迪提","star":"克里斯·海姆斯沃斯,凯特·布兰切特,汤姆·希德勒斯顿","cat":"动作,冒险,奇幻","pn":264,"scm":"","imax":true,"snum":113194,"dur":130,"time":"","id":249894},{"late":false,"cnms":0,"sn":0,"showInfo":"今天129家影院放映816场","wish":47680,"3d":false,"src":"","showDate":"","img":"http://p1.meituan.net/165.220/movie/66b96e1da8117d1b69961d0634cf6ee0637593.jpg","nm":"密战","sc":8.1,"ver":"2D","rt":"2017-11-03上映","preSale":0,"vd":"","dir":"钟少雄","star":"郭富城,赵丽颖,张翰","cat":"剧情,动作,战争","pn":123,"scm":"地下探情报，献身发信号","imax":false,"snum":30733,"dur":102,"time":"","id":338328},{"late":false,"cnms":0,"sn":0,"showInfo":"今天130家影院放映779场","wish":92251,"3d":true,"src":"","showDate":"","img":"http://p1.meituan.net/165.220/movie/ceca5272db49154554f96829886f175a4555828.jpg","nm":"全球风暴","sc":8.7,"ver":"2D/3D/IMAX 3D/中国巨幕","rt":"2017-10-27上映","preSale":0,"vd":"","dir":"迪安·德夫林","star":"杰拉德·巴特勒,吉姆·斯特吉斯,艾比·考尼什","cat":"动作,惊悚,灾难","pn":55,"scm":"狂暴版后天，灾难满人间","imax":true,"snum":135072,"dur":109,"time":"","id":338402},{"late":false,"cnms":0,"sn":0,"showInfo":"2017-11-10 本周五上映","wish":60219,"3d":false,"src":"","showDate":"","img":"http://p1.meituan.net/165.220/movie/505d21411aeec915a8aaad9d2bc1f29e7386737.jpg","nm":"东方快车谋杀案","sc":0,"ver":"2D","rt":"本周五上映","preSale":1,"vd":"","dir":"肯尼思·布拉纳","star":"肯尼思·布拉纳,约翰尼·德普,王千源","cat":"剧情,悬疑,犯罪","pn":96,"scm":"","imax":false,"snum":460,"dur":114,"time":"","id":344422},{"late":false,"cnms":0,"sn":0,"showInfo":"2017-11-10 本周五上映","wish":29258,"3d":true,"src":"","showDate":"","img":"http://p0.meituan.net/165.220/movie/fdf8d37852ddd13807fc3010546f86342371584.jpg","nm":"狂兽","sc":0,"ver":"2D/3D/中国巨幕","rt":"本周五上映","preSale":1,"vd":"","dir":"李子俊","star":"张晋,余文乐,文咏珊","cat":"剧情,动作,犯罪","pn":85,"scm":"欲念比金重，难以辨奸忠","imax":false,"snum":790,"dur":100,"time":"","id":344500},{"late":false,"cnms":0,"sn":0,"showInfo":"2017-11-10 本周五上映","wish":23728,"3d":false,"src":"","showDate":"","img":"http://p0.meituan.net/165.220/movie/ddfbc7a81a453999122bb8f4f9e76c22529899.png","nm":"烽火芳菲","sc":0,"ver":"2D","rt":"本周五上映","preSale":1,"vd":"","dir":"比利·奥古斯特","star":"刘亦菲,埃米尔·赫斯基,李芳淙","cat":"爱情,战争,历史","pn":92,"scm":"飞虎队迫降，村民帮帮忙","imax":false,"snum":761,"dur":97,"time":"","id":343985},{"late":false,"cnms":0,"sn":0,"showInfo":"今天109家影院放映336场","wish":12084,"3d":false,"src":"","showDate":"","img":"http://p0.meituan.net/165.220/movie/dd015fae6c6e85fb90adcd37af038a60382225.jpg","nm":"七十七天","sc":8.8,"ver":"2D","rt":"2017-11-03上映","preSale":0,"vd":"","dir":"赵汉唐","star":"江一燕,赵汉唐","cat":"剧情,冒险","pn":150,"scm":"","imax":false,"snum":9332,"dur":115,"time":"","id":618704},{"late":false,"cnms":0,"sn":0,"showInfo":"今天95家影院放映253场","wish":244337,"3d":true,"src":"","showDate":"","img":"http://p1.meituan.net/165.220/movie/8032e4157e1fb1f6cdb52fcc37698c074599808.jpg","nm":"王牌特工2：黄金圈","sc":8.7,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"2017-10-20上映","preSale":0,"vd":"","dir":"马修·沃恩","star":"科林·费尔斯,塔伦·埃格顿,朱丽安·摩尔","cat":"动作,冒险,喜剧","pn":416,"scm":"科林叔回归，贱谍再起飞","imax":true,"snum":169444,"dur":139,"time":"","id":341173},{"late":false,"cnms":0,"sn":0,"showInfo":"今天97家影院放映197场","wish":12428,"3d":false,"src":"","showDate":"","img":"http://p1.meituan.net/165.220/movie/8b8a04b3b3ccc8da05800574115178723211760.jpg","nm":"相爱相亲","sc":8.8,"ver":"2D","rt":"2017-11-03上映","preSale":0,"vd":"","dir":"张艾嘉","star":"张艾嘉,田壮壮,郎月婷","cat":"剧情,爱情","pn":333,"scm":"一桩小恩怨，三代大和解","imax":false,"snum":6074,"dur":121,"time":"","id":346641},{"late":false,"cnms":0,"sn":0,"showInfo":"今天66家影院放映165场","wish":284299,"3d":false,"src":"","showDate":"","img":"http://p0.meituan.net/165.220/movie/62e854fcfdae277751c3bae23ea110aa131670.jpg","nm":"羞羞的铁拳","sc":9.1,"ver":"2D/IMAX 2D/中国巨幕/全景声","rt":"2017-09-30上映","preSale":0,"vd":"","dir":"宋阳,张吃鱼","star":"艾伦,马丽,沈腾","cat":"喜剧,爱情","pn":416,"scm":"送你哈哈拳，不笑不要钱","imax":true,"snum":988219,"dur":100,"time":"","id":1198214}]}
     */

    private ControlBean control;
    private int status;
    private DataBean data;

    public ControlBean getControl() {
        return control;
    }

    public void setControl(ControlBean control) {
        this.control = control;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @SuppressWarnings("WeakerAccess")
    public static class ControlBean {
        /**
         * expires : 1800
         */

        private int expires;

        public int getExpires() {
            return expires;
        }

        public void setExpires(int expires) {
            this.expires = expires;
        }
    }

    public static class DataBean {
        /**
         * hasNext : true
         * movies : [{"late":false,"cnms":0,"sn":0,"showInfo":"今天133家影院放映2517场","wish":218426,"3d":true,"src":"","showDate":"","img":"http://p1.meituan.net/165.220/movie/579a0919e926a80ad14c717c8d8a8394259181.jpg","nm":"雷神3：诸神黄昏","sc":8.9,"ver":"3D/IMAX 3D/中国巨幕/全景声","rt":"2017-11-03上映","preSale":0,"vd":"","dir":"塔伊加·维迪提","star":"克里斯·海姆斯沃斯,凯特·布兰切特,汤姆·希德勒斯顿","cat":"动作,冒险,奇幻","pn":264,"scm":"","imax":true,"snum":113194,"dur":130,"time":"","id":249894},{"late":false,"cnms":0,"sn":0,"showInfo":"今天129家影院放映816场","wish":47680,"3d":false,"src":"","showDate":"","img":"http://p1.meituan.net/165.220/movie/66b96e1da8117d1b69961d0634cf6ee0637593.jpg","nm":"密战","sc":8.1,"ver":"2D","rt":"2017-11-03上映","preSale":0,"vd":"","dir":"钟少雄","star":"郭富城,赵丽颖,张翰","cat":"剧情,动作,战争","pn":123,"scm":"地下探情报，献身发信号","imax":false,"snum":30733,"dur":102,"time":"","id":338328},{"late":false,"cnms":0,"sn":0,"showInfo":"今天130家影院放映779场","wish":92251,"3d":true,"src":"","showDate":"","img":"http://p1.meituan.net/165.220/movie/ceca5272db49154554f96829886f175a4555828.jpg","nm":"全球风暴","sc":8.7,"ver":"2D/3D/IMAX 3D/中国巨幕","rt":"2017-10-27上映","preSale":0,"vd":"","dir":"迪安·德夫林","star":"杰拉德·巴特勒,吉姆·斯特吉斯,艾比·考尼什","cat":"动作,惊悚,灾难","pn":55,"scm":"狂暴版后天，灾难满人间","imax":true,"snum":135072,"dur":109,"time":"","id":338402},{"late":false,"cnms":0,"sn":0,"showInfo":"2017-11-10 本周五上映","wish":60219,"3d":false,"src":"","showDate":"","img":"http://p1.meituan.net/165.220/movie/505d21411aeec915a8aaad9d2bc1f29e7386737.jpg","nm":"东方快车谋杀案","sc":0,"ver":"2D","rt":"本周五上映","preSale":1,"vd":"","dir":"肯尼思·布拉纳","star":"肯尼思·布拉纳,约翰尼·德普,王千源","cat":"剧情,悬疑,犯罪","pn":96,"scm":"","imax":false,"snum":460,"dur":114,"time":"","id":344422},{"late":false,"cnms":0,"sn":0,"showInfo":"2017-11-10 本周五上映","wish":29258,"3d":true,"src":"","showDate":"","img":"http://p0.meituan.net/165.220/movie/fdf8d37852ddd13807fc3010546f86342371584.jpg","nm":"狂兽","sc":0,"ver":"2D/3D/中国巨幕","rt":"本周五上映","preSale":1,"vd":"","dir":"李子俊","star":"张晋,余文乐,文咏珊","cat":"剧情,动作,犯罪","pn":85,"scm":"欲念比金重，难以辨奸忠","imax":false,"snum":790,"dur":100,"time":"","id":344500},{"late":false,"cnms":0,"sn":0,"showInfo":"2017-11-10 本周五上映","wish":23728,"3d":false,"src":"","showDate":"","img":"http://p0.meituan.net/165.220/movie/ddfbc7a81a453999122bb8f4f9e76c22529899.png","nm":"烽火芳菲","sc":0,"ver":"2D","rt":"本周五上映","preSale":1,"vd":"","dir":"比利·奥古斯特","star":"刘亦菲,埃米尔·赫斯基,李芳淙","cat":"爱情,战争,历史","pn":92,"scm":"飞虎队迫降，村民帮帮忙","imax":false,"snum":761,"dur":97,"time":"","id":343985},{"late":false,"cnms":0,"sn":0,"showInfo":"今天109家影院放映336场","wish":12084,"3d":false,"src":"","showDate":"","img":"http://p0.meituan.net/165.220/movie/dd015fae6c6e85fb90adcd37af038a60382225.jpg","nm":"七十七天","sc":8.8,"ver":"2D","rt":"2017-11-03上映","preSale":0,"vd":"","dir":"赵汉唐","star":"江一燕,赵汉唐","cat":"剧情,冒险","pn":150,"scm":"","imax":false,"snum":9332,"dur":115,"time":"","id":618704},{"late":false,"cnms":0,"sn":0,"showInfo":"今天95家影院放映253场","wish":244337,"3d":true,"src":"","showDate":"","img":"http://p1.meituan.net/165.220/movie/8032e4157e1fb1f6cdb52fcc37698c074599808.jpg","nm":"王牌特工2：黄金圈","sc":8.7,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"2017-10-20上映","preSale":0,"vd":"","dir":"马修·沃恩","star":"科林·费尔斯,塔伦·埃格顿,朱丽安·摩尔","cat":"动作,冒险,喜剧","pn":416,"scm":"科林叔回归，贱谍再起飞","imax":true,"snum":169444,"dur":139,"time":"","id":341173},{"late":false,"cnms":0,"sn":0,"showInfo":"今天97家影院放映197场","wish":12428,"3d":false,"src":"","showDate":"","img":"http://p1.meituan.net/165.220/movie/8b8a04b3b3ccc8da05800574115178723211760.jpg","nm":"相爱相亲","sc":8.8,"ver":"2D","rt":"2017-11-03上映","preSale":0,"vd":"","dir":"张艾嘉","star":"张艾嘉,田壮壮,郎月婷","cat":"剧情,爱情","pn":333,"scm":"一桩小恩怨，三代大和解","imax":false,"snum":6074,"dur":121,"time":"","id":346641},{"late":false,"cnms":0,"sn":0,"showInfo":"今天66家影院放映165场","wish":284299,"3d":false,"src":"","showDate":"","img":"http://p0.meituan.net/165.220/movie/62e854fcfdae277751c3bae23ea110aa131670.jpg","nm":"羞羞的铁拳","sc":9.1,"ver":"2D/IMAX 2D/中国巨幕/全景声","rt":"2017-09-30上映","preSale":0,"vd":"","dir":"宋阳,张吃鱼","star":"艾伦,马丽,沈腾","cat":"喜剧,爱情","pn":416,"scm":"送你哈哈拳，不笑不要钱","imax":true,"snum":988219,"dur":100,"time":"","id":1198214}]
         */

        private boolean hasNext;
        private List<MoviesBean> movies;

        public boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }

        public List<MoviesBean> getMovies() {
            return movies;
        }

        public void setMovies(List<MoviesBean> movies) {
            this.movies = movies;
        }

        public static class MoviesBean {
            /**
             * late : false
             * cnms : 0
             * sn : 0
             * showInfo : 今天133家影院放映2517场
             * wish : 218426
             * 3d : true
             * src :
             * showDate :
             * img : http://p1.meituan.net/165.220/movie/579a0919e926a80ad14c717c8d8a8394259181.jpg
             * nm : 雷神3：诸神黄昏
             * sc : 8.9
             * ver : 3D/IMAX 3D/中国巨幕/全景声
             * rt : 2017-11-03上映
             * preSale : 0
             * vd :
             * dir : 塔伊加·维迪提
             * star : 克里斯·海姆斯沃斯,凯特·布兰切特,汤姆·希德勒斯顿
             * cat : 动作,冒险,奇幻
             * pn : 264
             * scm :
             * imax : true
             * snum : 113194
             * dur : 130
             * time :
             * id : 249894
             */

            private boolean late;
            private int cnms;
            private int sn;
            private String showInfo;
            private int wish;
            @SerializedName("3d")
            private boolean _$3d;
            private String src;
            private String showDate;
            private String img;
            private String nm;
            private double sc;
            private String ver;
            private String rt;
            private int preSale;
            private String vd;
            private String dir;
            private String star;
            private String cat;
            private int pn;
            private String scm;
            private boolean imax;
            private int snum;
            private int dur;
            private String time;
            private int id;

            public boolean isLate() {
                return late;
            }

            public void setLate(boolean late) {
                this.late = late;
            }

            public int getCnms() {
                return cnms;
            }

            public void setCnms(int cnms) {
                this.cnms = cnms;
            }

            public int getSn() {
                return sn;
            }

            public void setSn(int sn) {
                this.sn = sn;
            }

            public String getShowInfo() {
                return showInfo;
            }

            public void setShowInfo(String showInfo) {
                this.showInfo = showInfo;
            }

            public int getWish() {
                return wish;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }

            public boolean is_$3d() {
                return _$3d;
            }

            public void set_$3d(boolean _$3d) {
                this._$3d = _$3d;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getShowDate() {
                return showDate;
            }

            public void setShowDate(String showDate) {
                this.showDate = showDate;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public double getSc() {
                return sc;
            }

            public void setSc(double sc) {
                this.sc = sc;
            }

            public String getVer() {
                return ver;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public int getPreSale() {
                return preSale;
            }

            public void setPreSale(int preSale) {
                this.preSale = preSale;
            }

            public String getVd() {
                return vd;
            }

            public void setVd(String vd) {
                this.vd = vd;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public String getCat() {
                return cat;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public int getPn() {
                return pn;
            }

            public void setPn(int pn) {
                this.pn = pn;
            }

            public String getScm() {
                return scm;
            }

            public void setScm(String scm) {
                this.scm = scm;
            }

            public boolean isImax() {
                return imax;
            }

            public void setImax(boolean imax) {
                this.imax = imax;
            }

            public int getSnum() {
                return snum;
            }

            public void setSnum(int snum) {
                this.snum = snum;
            }

            public int getDur() {
                return dur;
            }

            public void setDur(int dur) {
                this.dur = dur;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
