import { createRouter, createWebHistory } from 'vue-router'
import indexView from '@/views/index.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'index',
      component: indexView,
      children: [
        {
          name: "Manage",
          path: "/manage",
          component: () => import('@/views/customer/manage.vue'),
        },
        {
          name: "See",
          path: "/see",
          component: () => import('@/views/customer/see.vue'),
        }
      ]
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('@/views/login/index.vue')
    },
  ],
})

router.beforeEach((to, from, next) => {
  const isAuthenticated = localStorage.getItem('jwtToken');  // 使用 token 进行判断

  if (to.path !== '/login' && !isAuthenticated) {
    // 如果用户没有登录且要访问的不是登录页面，则重定向到登录页面
    next('/login');
  } else {
    next();  // 如果是登录页面或者已登录，则继续执行
  }
});

export default router
