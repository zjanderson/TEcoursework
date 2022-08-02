import Vue from 'vue'
import VueRouter from 'vue-router'
import AddReview from '../views/AddReview.vue'
import ProductDetail from '../views/ProductDetail.vue'
import ProductsList from '../views/ProductsList.vue'

Vue.use(VueRouter)

const routes = [
  {
    name: 'products', //this is just a made-up name, we can use it later to refer to things if we want to
    path: '/',
    component: ProductsList
  }, 

  {
    name: 'product-detail',
    path: '/products/:id',
    component: ProductDetail
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
