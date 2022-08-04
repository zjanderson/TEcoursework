<template>
  <div>
    <h3 class="book-author">{{ book.author }}</h3>
    <h2 class="book-title">{{ book.title }}</h2>
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    <p></p>
  </div>
</template>

<script>

// import BookCard from '@/components/BookCard.vue';

export default {
  props: ["book"],
  
  computed: {
    hasReadText() {
      if (this.book.read) {
        return "I have read this book";
      }
      return "I have not read this book"
    }
  },
  components: {
    // BookCard
  }
}

</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
}

.card.read {
    background-color: lightgray;
}

.card .book-title {
    font-size: 1.5rem;
}

.card .book-author {
    font-size: 1rem;
}
</style>