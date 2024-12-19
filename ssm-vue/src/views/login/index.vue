<template>
    <div class="background">
        <div class="login">
          <el-form
            ref="ruleFormRef"
            style="max-width: 600px"
            :model="ruleForm"
            status-icon
            :rules="rules"
            label-width="auto"
            class="demo-ruleForm"
          >
          <el-form-item label="用户名" prop="username">
            <el-input v-model="ruleForm.username" autocomplete="off" />
          </el-form-item>

          <el-form-item label="密码" prop="password">
            <el-input v-model="ruleForm.password" type="password" autocomplete="off" />
          </el-form-item>

          <el-form-item>
            <el-button type="primary" @click="submitForm(ruleFormRef)">
              登录
            </el-button>
            <el-button @click="resetForm(ruleFormRef)">重置</el-button>
          </el-form-item>
      </el-form>
        </div>
    </div>
</template>

<script setup>

import { reactive, ref } from 'vue';
import { login } from '@/api/emp'; // 引入你的登录请求
import router from '@/router';
import { ElMessage } from 'element-plus';

const ruleFormRef = ref();
const ruleForm = reactive({
  username: '',
  password: '',
});

const rules = reactive({
  username: [
    { required: true, message: '请输入用户名', trigger: 'blur' },
  ],
  password: [
    { required: true, message: '请输入密码', trigger: 'blur' },
  ],
});

const submitForm = (formEl) => {
  if (!formEl) return;
  formEl.validate((valid) => {
    if (valid) {
      console.log('表单验证通过，提交数据：', ruleForm);
      login(ruleForm) // 调用登录请求
        .then((response) => {
          if(response.data.code==500){
            ElMessage.warning(response.data.msg)
          }else if(response.data.code == 200){

            window.localStorage.setItem('jwtToken',response.data.data.token)
            window.localStorage.setItem('userInfo',JSON.stringify(response.data.data.userinfo))
            console.log('查看接口返回的信息', response.data.data.userinfo);
            ElMessage.success("登录成功")
            router.push('/manage')
          }
        })
        .catch((error) => {
          console.log('登录失败：', response.data.message);
          
        });
    } else {
      console.log('表单验证失败');
    }
  });
};

</script>

<style lang="scss">

.background {
    background-color: red;
    background-image: url('/src/assets/bg6.jpg');
    background-size: cover; /* 确保背景图覆盖整个元素 */
    width: 100%; /* 宽度填满父容器 */
    min-height: 100vh; /* 最小高度为视口高度，确保背景图不消失 */
    position: relative; /* 使其成为定位容器 */

    .login {
        // background-color: rgb();
        width: 40%; /* 宽度占背景的50% */
        height: 50%; /* 高度占背景的30% */
        position: absolute; /* 绝对定位，相对于背景容器定位 */
        top: 20%; /* 垂直位置，距离父容器顶部20% */
        right: 10px; /* 靠右对齐 */
        .demo-ruleForm{
            width: 100%; /* 确保表单宽度不超过 .login 的宽度 */
            height: 100%; /* 确保表单高度不超过 .login 的高度 */
            max-width: 100%;
            max-height: 100%;
        }
    }
}



</style>