<template>
  <div>
      <div v-if="isLoggedIn">Welcome, {{ $store.state.auth.user.username }} </div>
      <form @submit.prevent="login" v-else>
          <label for="username">Username: </label>
          <input v-model="username" id="username" type="text" autocomplete="off" required>
          
          <label for="password">Password: </label>
          <input v-model="password" id="password" type="password" autocomplete="off" required>

          <input type="submit" value="Login">
      </form>
  </div>
</template>

<script>
import authenticationService from '@/services/AuthenticationService.js';

export default {
    data() {
        return {
            username: '',
            password: ''
        }
    },

    computed: {
        isLoggedIn() {
            return this.$store.state.auth.token !== '';
        }
    },

    methods: {
        login() {
            authenticationService
                .login(this.username, this.password)
                .then(response => {
                    this.$store.commit('SET_AUTH', response.data);
                })
        }
    }
}
</script>

<style>

</style>