<template>
    <div>
      <h1>客户拜访</h1>
      <div v-if="user">
        <p>姓名: {{ user.name }}</p>
        <p>年龄: {{ user.age }}</p>
        <p>工资: {{ user.salary }}</p>
        <p>邮箱: {{ user.email }}</p>
      </div>
      <div v-else>
        <p>加载中...</p>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import axios from 'axios';
  
  // 使用 ref 定义响应式数据
  const user = ref();
  
  // 异步函数获取用户数据
  async function fetchUserData() {
    try {
      const response = await axios.get('http://localhost:8082/ssm_demo_war_exploded/emp/20');
      user.value = response.data; // 更新响应式数据
      console.log("从后端拿到的数据",response)
    } catch (error) {
      console.error('发生错误了:', error);
    }
  }
  
  // 在组件挂载时调用数据获取函数
  onMounted(() => {
    fetchUserData();
  });
  </script>
  
  <style lang="scss" scoped>
  h1 {
    font-size: 24px;
    color: #333;
  }
  
  p {
    font-size: 16px;
    margin: 5px 0;
  }
  
  div {
    padding: 20px;
    background-color: #f9f9f9;
    border-radius: 8px;
  }
  </style>
  