<template>
  <div id="home">
    <div class="home_header">
      <div class="home_address">
        <p ref="city">{{city}}</p>
      </div>
      <div class="home_search">
        <i class="iconfont icon-sousuo"></i>
        <input type="text">
      </div>
      <div class="home_plus" @click="showright=!showright">
        <i class="iconfont icon-jiahao"></i>
      </div>
      <rightSideBar v-show="showright"></rightSideBar>
    </div>
    <div class="home_sidebar">
      <swiper></swiper>
    </div>
   

    <!-- <div @click="jinrushangpin">商品1</div> -->
  </div>
</template>
<script>
import rightSideBar from '../commonComponents/rightSideBar'
import swiper from '../commonComponents/swiper'
export default {
  data(){
    return{
      city:undefined,
      showright:false
    }
  },
  methods: {
    jinrushangpin() {
      console.log("1");
      this.$router.push({ path: "/singlegood/sellgoods" });
    },
      //定位获得当前位置信息
            getMyLocation() {
                var geolocation = new qq.maps.Geolocation("NKOBZ-4NL34-RPCUS-D7FTI-OUMBO-4TB52", "gxy-Lemon");
                geolocation.getIpLocation(this.showPosition, this.showErr);
            },
            showPosition(position) {
                this.city = position.city
            },
            showErr() {
                console.log("定位失败");
                this.getMyLocation();//定位失败再请求定位，测试使用
            }
  },
  mounted(){
    this.getMyLocation()
  },
  components:{rightSideBar,swiper}
};
</script>



<style scoped>
.home_header{
  display: flex;
  height: 80px;
  background-color: antiquewhite;
  /* align-items: center;     垂直居中 */
}
.home_address{
border:1px solid green;
flex:0.2;
text-align: center;
height: 78px;
line-height: 78px;
}
.home_address p {
  font-size: 35px;
}
.home_search{
position: relative;
border:1px solid red;
flex:0.7;
text-align: center;
height: 78px;
line-height: 78px;
}
.home_search i {
  position: absolute;
  font-size: 35px;
  top:22px;
  right:40px;
}
.home_search input{
  width: 85%;
  height: 40px;
  padding:5px 5px;
  padding-left: 25px;
      border: 1px solid #b3cef9;
    border-radius: 8px;
}
.home_search input :focus{
  outline: 0;
    background: #fff;
    border: 3px solid #ccc;
}
.home_plus{
border:1px solid purple;
flex:0.1;
text-align: center;
padding-top: 17px;
}
.home_plus i{
  font-size: 45px;
}
</style>