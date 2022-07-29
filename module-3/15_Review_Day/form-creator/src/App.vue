<template>
  <div id="app">
    <the-main></the-main>
  </div>
</template>

<script>
import TheMain from './components/TheMain.vue';

export default {
  name: 'App',
  components: {
    TheMain
  }
}
</script>

<style>
* {
  font-family: Roboto, Verdana, Geneva, Tahoma, sans-serif;
  font-size: 16px;
}
body {
  background-color: rgb(255, 235, 192);
  margin: 0;
}
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

main {
  display: initial;
  width: 40%;
}

/* TODO: update to use classes rather than rely on element selectors */
header > ul { 
  display: flex;
  list-style-type: none;
}
header > ul > li {
  margin-left: 10px;
  margin-right: 10px;
  padding: 5px;
  cursor: pointer;
}

header > ul > li.active {
  border-bottom: 2px solid black;
}

.section {
  border-radius: 5px;
  background-color: white;
  color: black;
  border: 1px solid lightgray;
  margin-bottom: 20px;
  padding: 20px;
  font-size: .8rem;
  text-align: left;;
}

.required {
  color: red;
}

.button {
  border-radius: 5px;
  color: white;
  background-color: orangered;
  display: inline-block;
  padding: 5px 15px;
  min-width: 90px;
  height: 35px;
  border: 0;
  font-size: 1.2rem;
  cursor: pointer;
}

select {
  padding: 5px;
}

label {
  cursor: pointer;
}

input, textarea {
  border: none;
  border-bottom: 1px solid lightgray;
  padding: 5px;
}

input:focus, textarea:focus {
  outline: none;
  border-bottom: 1px solid black !important;
}

ul {
  list-style-type: none;
}
li:last-child {
  cursor: pointer;
}

a, a:visited, a:hover {
  color: rgb(75, 73, 73);
  text-decoration: none;
}
</style>
