import Vue from 'vue'
import VueRouter from 'vue-router'
import AddReview from '@/views/AddReview.vue'
import ProductDetail from '@/views/ProductDetail.vue'
import ProductsList from '@/views/ProductsList.vue'
import Blah from '@/views/Blah.vue'

Vue.use(VueRouter)

const routes = [
  {
    name: 'products',
    path: '/',
    component: ProductsList,
    alias: ['/products', '/products2']
  },

  {
    path: '/products3',
    redirect: { name: 'products' }
  },

  {
    name: 'product-detail',
    path: '/products/:id',
    component: ProductDetail
  },

  {
    path: '/blah',
    component: Blah
  },

  {
    name: 'add-review',
    path: '/products/:id/add-review',
    component: AddReview
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
