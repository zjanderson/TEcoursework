<template>
  <div>
    <h1>My Kanban Boards</h1>
    <div class="boards">

      <div class="loading" v-if="isLoading">
        <img src="../assets/ping_pong_loader.gif" />
      </div>

      <router-link 
        v-else
        class="board"
        v-for="board in boards" 
        v-bind:key="board.id"
        v-bind:to="{ name: 'Board', params: { id: board.id } }"
        v-bind:style="{ 'background-color': board.backgroundColor }">
          {{ board.title }}
        </router-link>

    </div>
  </div>
</template>

<script>
import boardsService from '../services/BoardService';

export default {
  data() {
    return {
      boards: [],
      isLoading: true
    };
  },
  created() {
    boardsService.getBoards().then(response => {
      this.boards = response.data;
      this.isLoading = false;
    });
  }
};
</script>

<style scoped>
.boards {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.board {
  background-color: #f7fafc;
  border-radius: 10px;
  padding: 40px;
  flex: 1;
  margin: 0 20px;
  text-align: center;
}
.loading {
  flex: 3;
}
a:link,
a:visited {
  color: rgb(243, 243, 243);
  text-decoration: none;
}
</style>
