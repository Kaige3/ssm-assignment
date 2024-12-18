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
                <el-form-item label="Password" prop="pass">
                    <el-input v-model="ruleForm.pass" type="password" autocomplete="off" />
                </el-form-item>
                <el-form-item label="Confirm" prop="checkPass">
                    <el-input
                        v-model="ruleForm.checkPass"
                        type="password"
                        autocomplete="off"
                    />
                </el-form-item>
                <el-form-item label="Age" prop="age">
                    <el-input v-model.number="ruleForm.age" />
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm(ruleFormRef)">
                        Submit
                    </el-button>
                    <el-button @click="resetForm(ruleFormRef)">Reset</el-button>
                </el-form-item>
            </el-form>
        </div>

    </div>
</template>

<script setup>

import { reactive, ref } from 'vue'

const ruleFormRef = ref(null)

const checkAge = (rule, value, callback) => {
  if (!value) {
    return callback(new Error('Please input the age'))
  }
  setTimeout(() => {
    if (!Number.isInteger(value)) {
      callback(new Error('Please input digits'))
    } else {
      if (value < 18) {
        callback(new Error('Age must be greater than 18'))
      } else {
        callback()
      }
    }
  }, 1000)
}

const validatePass = (rule, value, callback) => {
  if (value === '') {
    callback(new Error('Please input the password'))
  } else {
    if (ruleForm.checkPass !== '') {
      if (!ruleFormRef.value) return
      ruleFormRef.value.validateField('checkPass')
    }
    callback()
  }
}

const validatePass2 = (rule, value, callback) => {
  if (value === '') {
    callback(new Error('Please input the password again'))
  } else if (value !== ruleForm.pass) {
    callback(new Error("Two inputs don't match!"))
  } else {
    callback()
  }
}

const ruleForm = reactive({
  pass: '',
  checkPass: '',
  age: ''
})

const rules = reactive({
  pass: [{ validator: validatePass, trigger: 'blur' }],
  checkPass: [{ validator: validatePass2, trigger: 'blur' }],
  age: [{ validator: checkAge, trigger: 'blur' }]
})

const submitForm = (formEl) => {
  if (!formEl) return
  formEl.validate((valid) => {
    if (valid) {
      console.log('submit!')
    } else {
      console.log('error submit!')
    }
  })
}

const resetForm = (formEl) => {
  if (!formEl) return
  formEl.resetFields()
}




</script>

<style lang="scss">


.background {
    background-color: red;
    background-image: url('/src/assets/ssm登录封面.png');
    background-size: cover; /* 确保背景图覆盖整个元素 */
    width: 100%; /* 宽度填满父容器 */
    min-height: 100vh; /* 最小高度为视口高度，确保背景图不消失 */
    position: relative; /* 使其成为定位容器 */

    .login {
        background-color: rgb(178, 218, 244);
        width: 40%; /* 宽度占背景的50% */
        height: 50%; /* 高度占背景的30% */
        position: absolute; /* 绝对定位，相对于背景容器定位 */
        top: 20%; /* 垂直位置，距离父容器顶部20% */
        right: 10px; /* 靠右对齐 */
        overflow: hidden; /* 确保内容不会超出 .login 区域 */
        .demo-ruleForm{
            width: 100%; /* 确保表单宽度不超过 .login 的宽度 */
            height: 100%; /* 确保表单高度不超过 .login 的高度 */
            max-width: 100%;
            max-height: 100%;
        }
    }
}



</style>