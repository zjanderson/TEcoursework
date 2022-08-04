<template>
  <book-details :book="selectedBook"></book-details>
</template>

<script>

import BookDetails from '@/components/BookDetails.vue'
export default {

  components: {
    BookDetails,
  },

  computed: {
    selectedBook() {
      const book = this.$store.state.books.find(book => {
        if (book.isbn === this.$route.params.isbn) {
          return true;
        }
        return false;
      });
      return book;
    }
  }

}
</script>

<style>

</style>