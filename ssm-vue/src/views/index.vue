<template>
    <div class="common-layout">
      <el-container class="container">
        <!-- 头 -->
        <el-header class="container-head">
            <el-menu
                :default-active="activeIndex2"
                class="el-menu-demo"
                mode="horizontal"
                background-color="#545c64"
                text-color="#fff"
                active-text-color="#ffd04b"
                @select="handleSelect"
            >
                <el-menu-item index="1">BOOT客户管理系统v2.0</el-menu-item>
               
                <el-menu-item index="3" disabled>Info</el-menu-item>
                <el-menu-item index="4">Orders</el-menu-item>
            </el-menu>
        </el-header>
        <!-- 下方内容，左边菜单和右边路由内容 -->
        <el-container class="container-box">
            <!-- 左边内容 -->
            <el-aside class="container-left" width="200px">
                <el-row class="tac">
                 <el-col :span="24">
                    <h5 class="mb-2">这里会是一个搜索框</h5>
                    <el-menu
                        default-active="1"
                        class="el-menu-vertical-demo"
                        @open="handleOpen"
                        @close="handleClose"
                    >
                        <router-link to="/manage">
                            <el-menu-item index="1">
                                <template #title>
                                    <el-icon><Edit/></el-icon>
                                    客户管理
                                </template>
                            </el-menu-item>
                        </router-link>
                        
                        <router-link to="/see">
                            <el-menu-item index="2">
                                <template #title> 
                                    <el-icon><Monitor /></el-icon>
                                    客户拜访
                                </template>
                            </el-menu-item>
                        </router-link>
                    </el-menu>
                    </el-col>
                </el-row>
            </el-aside>
          <!-- 路由显示区域 -->
          <el-main class="container-right">
            <RouterView/>
          </el-main>
        </el-container>
      </el-container>
    </div>
  </template>
<script setup>

// 从login 跳转到 / 页面后台，请求数据



</script>

<style lang="scss">
.container{
    position:absolute;
    top: 0;
    left: 0;
    color: black;
    background-color: orange;
    height: 100%;
    width: 100%;
}
.container-head{
    background-color: red;
    display: flex;
    flex-direction: column;
    padding: 0;
    direction: cl;
    justify-content: center;
    .el-menu-demo{
        display: flex;
        width: auto;
    }
}
.container-left{
    background-color: greenyellow;
    display: flex;
    justify-content: center;
    .tac{
        width: 100%;
    }

}

</style>