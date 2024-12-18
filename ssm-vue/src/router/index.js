import { createRouter, createWebHistory } from 'vue-router'
import indexView from '@/views/index.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/login',
      name: 'login',
      component: () => import('@/views/login/index.vue')
    },
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
  ],
})

export default router
