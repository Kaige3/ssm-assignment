<script lang="ts" setup>
import { computed, ref,onMounted,reactive } from 'vue'
import { queryByPage,add,grade,industry,source,queryById,deleteById,edit,queryByIdEcho } from '@/api/emp';
import { ElMessage, ElMessageBox } from 'element-plus'
import { id, tr } from 'element-plus/es/locale';

interface Emp {
    id: number,
  name: string,
  linkman: string,
  phone: string,
  telephone:string,
  postalCode:string,
  address:string,
  sourceId:string,
  industryId:string,
  gradeId:string,
}

const search = ref('')


// 响应式数据
const tableData = ref<Emp[]>([]); // 表格数据
const total = ref(); // 总记录数
const currentPage = ref(); // 当前页码
const pageSize = ref(10); // 每页条数

const open = ref(false);

const value = ref('');

const form = reactive({})


// 筛选后的表格数据
const filterTableData = computed(() => {
  const lowerSearch = search.value.toLowerCase();
  return tableData.value.filter(
    (data) =>
      (!lowerSearch || data.name.toLowerCase().includes(lowerSearch)) &&
      (!value.value || data.id === Number(value.value))
  );
});

// 表格操作
const handleEdit = (index: number, row: Emp) => {
    open.value = true;
    // 重置表单操作
    reset();
    // 数据回显
    queryByIdEcho(row.id).then(response =>{
         console.log("根据id查询用户信息",response.data.data)
         // 更新响应式对象的属性
        //  更新 form 中的数据
         Object.assign(formInline, response.data.data);
    })
    
  console.log('编辑:', index, row);
};

const handleDelete = (index: number, row: Emp) => {
    ElMessageBox.confirm('确认删除此数据？','删除数据',{
        confirmButtonText:'确认',
        cancelButtonText:'取消',
        type:'warning'
    })
    .then(()=>{
        deleteById(row.id)
        .then(Response =>{
            tableData.value.splice(index,1);
            ElMessage.success('删除成功');
        }).catch(error =>{
            ElMessage.error('删除失败',error)
            console.log("当前索引为",row.id)
        })
    })
    .catch(()=>{
        ElMessage.info('取消删除')
    })
};


const queryParams = ref({
    pageNum:1,
    pageSize:10,
    name:'',
    sourceId:'',
    industryId:'',
    gradeId:''
})


// 请求客户数据
const fetchTableData = async (pageNum = 1, size = 10) => {
  try {
    const response = await queryByPage(pageNum,size)
    const pageInfo = response.data.data;
    tableData.value = pageInfo.list; // 更新表格数据
    total.value = pageInfo.total; // 更新总记录数
  } catch (error) {
    console.error('加载数据失败:', error);
  }
};

// 存放求情数据
const industryId = ref([])
const sourceId = ref([])
const gradeId = ref([])

// 请求 客户来源，所属行业，客户级别
const fetchTotalData = async ()=>{

    try {
        const response =  await source();
        const sourceData = response.data.data;
        console.log('拿到source数据',sourceData)
        sourceId.value = sourceData;
    } catch (error) {
        console.log(error)
    }

    try {
        const response =  await industry();
        const industryData = response.data.data;
        console.log('拿到source数据',industryData)
        industryId.value = industryData;
    } catch (error) {
        console.log(error)
    }

    try {
        const response =  await grade();
        const gradeData = response.data.data;
        console.log('拿到source数据',gradeData)
        gradeId.value = gradeData;
    } catch (error) {
        console.log(error)
    }

    // 所有数据获取完后打印表单数据
    console.log('表单数据：', formInline);

}

// 新增用户对话框
const handleClose = (done: () => void) => {
  ElMessageBox.confirm('Are you sure to close this dialog?')
    .then(() => {
      done()
    })
    .catch(() => {
      // catch error
    })
}
// 处理新增用户 
function handleAdd(){
    open.value = true;
    reset();
}


const formInline = reactive({
    id:'',
    name: '', // 这些值从表单中获取
    linkman: '',
    phone: '',
    telephone: '',
    postalCode: '',
    address: '',
    sourceId: '',
    industryId: '',
    gradeId: ''
})

function submitForm() {

    console.log("提交表单数据为",formInline)

    open.value = false;
    if(formInline.id == ''){
        add(formInline)      // 将 formInline 作为 data 参数传递给 add 函数
        .then(response => {
            ElMessage.success('新增成功')
            // 在这里处理成功的逻辑，例如提示用户、刷新表格等
        })
        .catch(error => {
            ElMessage.warning('新增失败')
            // 在这里处理失败的逻辑
        });
        fetchTableData();
    }else{
        edit(formInline.id,formInline).then(response =>{
            ElMessage.success('修改成功');
        }).catch(error=>{
            ElMessage.warning('修改失败');
        })
        fetchTableData();
    }
}

// 分页切换触发请求
const handlePageChange = (newPage: number) => {
  currentPage.value = newPage;
  fetchTableData(newPage, pageSize.value);
};

// 页面加载时初始化数据
onMounted(() => {
  fetchTableData(currentPage.value, pageSize.value);
//   拿到三种信息
  fetchTotalData();
});

// 客户搜索
const handleQuery = () => {
  // 排除掉空字符串的查询条件
  const validQuery = { ...queryParams.value };
  Object.keys(validQuery).forEach(key => {
    if (validQuery[key] === '') {
      delete validQuery[key]; // 删除空值字段
    }
  });
// 根据name,三个id动态查询
  queryById(validQuery)
    .then(response => {
      if (response.data.code === 200) {
        tableData.value = response.data.data.list; // 这里是接口返回的实际数据
      } else {
        console.error('查询失败:', response.data.msg);
      }
    })
    .catch(error => {
      console.error('查询错误:', error);
    });
};

// 重置查询条件
const resetQueryParams = () => {
  queryParams.value = {
    pageNum: 1,
    pageSize: 10,
    name: '',
    sourceId: '',
    industryId: '',
    gradeId: ''
  };
};

// 重置表单
function reset(){
    formInline.address='';
    formInline.gradeId='';
    formInline.industryId='';
    formInline.linkman='';
    formInline.name='';
    formInline.phone='';
    formInline.postalCode='';
    formInline.sourceId='';
    formInline.telephone='';
}

</script>
<template>
<div class="search">
    <!-- 页面标题 -->
    <div class="header">客户管理</div>
    <!-- 搜索和筛选 -->
    <div class="select-container">
        <!-- 输入框 -->
        <div class="select">
            <span>客户名称</span>
            <el-input
                v-model="queryParams.name"
                style="width: 240px"
                placeholder="请输入客户名称"
            />
        </div>  
        <!-- 客户来源 -->
        <div class="select">
            <span>客户来源</span>
            <el-select
            v-model="queryParams.sourceId"
            placeholder="请选择"
            style="width: 240px"
            >
            <el-option
                v-for="item in sourceId"
                :key="item.sourceId"
                :label="item.sourceName"
                :value="item.sourceId"
            />
            </el-select>
        </div>
        <!-- 所属行业 -->
        <div class="select">
            <span>所属行业</span>
            <el-select
            v-model="queryParams.industryId"
            placeholder="请选择"
            style="width: 240px"
            >
            <el-option
                v-for="item in industryId"
                :key="item.industryId"
                :label="item.industryName"
                :value="item.industryId"
            />
            </el-select>
        </div>
        <!-- 客户级别 -->
        <div class="select">
            <span>客户级别</span>
            <el-select
            v-model="queryParams.gradeId"
            placeholder="请选择"
            style="width: 240px"
            >
            <el-option
                v-for="item in gradeId"
                :key="item.gradeId"
                :label="item.gradeName"
                :value="item.gradeId"
            />
            </el-select>
        </div>
        <div class="button">
            <el-button type="primary" class="search-button" @click="handleQuery">查询</el-button>
            <!-- 重置按钮 -->
            <el-button type="default" class="reset-button" @click="resetQueryParams">重置</el-button>
        </div>
    </div>
</div>

<!-- 表格数据 -->
 <!-- 新增用户 -->
<el-button type="primary" @click="handleAdd">新增</el-button>
<div class="table">
    <h3 class="title">客户信息列表</h3>
    <div class="data">
        <el-table
            :data="filterTableData"
            style="width: 100%"
            v-loading="tableData.length === 0"
            class="table-data"
        >
            <el-table-column label="编号" prop="id" />
            <el-table-column label="客户名称" prop="name" />
            <el-table-column label="联系人" prop="linkman" />
            <el-table-column label="客户来源" prop="sourceId" />
            <el-table-column label="客户所属行业" prop="industryId" />
            <el-table-column label="客户级别" prop="gradeId" />
            <el-table-column label="固定电话" prop="telephone" />
            <el-table-column label="手机" prop="phone" />
    
            <el-table-column align="right" label="操作" class="options">
                <template #default="scope" >
                    <el-button size="small" @click="handleEdit(scope.$index, scope.row)" open="true" class="option"
                    >编辑</el-button
                    >
                    <el-button
                    size="small"
                    type="danger"
                    @click="handleDelete(scope.$index, scope.row)" class="option"
                    >删除</el-button
                    >
                </template>
            </el-table-column>
        </el-table>
    </div>
    <!-- 分页数 导航 -->
    <div class="pageResult">
        <el-pagination
            v-model:current-page="currentPage"
            :page-size="pageSize"
            :total="total"
            layout="prev, pager, next"
            @current-change="handlePageChange"
        />
    </div>
</div> 

<!-- 新增客户对话框 -->
<el-dialog
    v-model="open"
    title="新建客户信息"
    width="500"
    :before-close="handleClose"
    class="add-dialog"
  >
    <template #footer>
      <div class="dialog-footer">

        <el-form :inline="true" :model="formInline" class="demo-form-inline">
            <!-- 客户名称 -->
            <el-form-item label="客户名称">
            <el-input v-model="formInline.name" placeholder="客户名称" clearable />
            </el-form-item>

            <!-- 客户来源 -->
            <el-form-item label="客户来源">
                <el-select
                    v-model="formInline.sourceId"
                    placeholder="客户来源"
                    clearable
                >
                    <el-option
                    v-for="item in sourceId" 
                    :key="item.sourceId"
                    :label="item.sourceName" 
                    :value="item.sourceId" />
                </el-select>
            </el-form-item>

            <!-- 所属行业 -->
            <el-form-item label="所属行业">
                <el-select
                    v-model="formInline.industryId"
                    placeholder="所属行业"
                    clearable
                >
                    <el-option 
                    v-for="item in industryId" 
                    :key="item.industryId" 
                    :label="item.industryName" 
                    :value="item.industryId" />
                </el-select>
            </el-form-item>
            <!-- 客户级别 -->
            <el-form-item label="客户级别">
                <el-select
                    v-model="formInline.gradeId"
                    placeholder="客户级别"
                    clearable
                >
                    <el-option
                    v-for="item in gradeId"
                    :key="item.gradeId"
                    :label="item.gradeName" 
                    :value="item.gradeId" />
                </el-select>
            </el-form-item>

            <!-- 联系人 -->
            <el-form-item label="联系人">
            <el-input v-model="formInline.linkman" placeholder="联系人" clearable />
            </el-form-item>
            <!-- 固定电话 -->
            <el-form-item label="固定电话">
            <el-input v-model="formInline.telephone" placeholder="固定电话" clearable />
            </el-form-item>
            <!-- 移动电话 -->
            <el-form-item label="移动电话">
            <el-input v-model="formInline.phone" placeholder="移动电话" clearable />
            </el-form-item>
            <!-- 邮政编码 -->
            <el-form-item label="邮政编码">
            <el-input v-model="formInline.postalCode" placeholder="邮政编码" clearable />
            </el-form-item>
            <!-- 联系地址 -->
            <el-form-item label="联系地址">
            <el-input v-model="formInline.address" placeholder="联系地址" clearable />
            </el-form-item>
        </el-form>
      </div>
        <div class="button">
            <el-button @click="open = false">取消</el-button>
            <el-button type="primary" @click="submitForm">
            确认
            </el-button>
        </div>
    </template>
  </el-dialog>
</template>
<style lang="scss">
.header{
    margin:20px 0;
    font-size:30px;
    border-bottom:1px solid black;
}
.select-container{
    display:flex;
    border: 1px solid gray;
    padding:10px;
    margin-bottom:30px;
    .select{
        display: flex;
        margin-right:10px;
        justify-content: center;
        align-items: center;
    }
    
    .button{
        display: flex;
    }
}

.pageResult{
    display:flex;
    justify-content:end;
    margin-top:10px;
}
.table{
    .title{
        background-color:white;
        border-bottom:1px solid black;
    }
    .data{
        background-color:oran
}
}
.dialog-footer{
    display:flex;
    .demo-form-inline{
        display:flex;
        flex-direction:column;
    }
}
// 搜索
.search{
    .search-button {
        margin-left: 5px;
    }
}

</style>
  
