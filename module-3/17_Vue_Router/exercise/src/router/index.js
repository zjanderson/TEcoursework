import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home.vue';
import MyBooks from '@/views/MyBooks.vue';
import NewBook from '@/views/NewBook.vue';
import Book from '@/views/Book.vue';

Vue.use(VueRouter);

const routes = [ //put in our routes!
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/myBooks',
    name: 'myBooks',
    component: MyBooks
  },
  {
    path: '/addBook',
    name: 'addBook',
    component: NewBook
  },
  {
  path: '/book/:isbn',
  name: 'bookDetails',
  component: Book
  },

];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
