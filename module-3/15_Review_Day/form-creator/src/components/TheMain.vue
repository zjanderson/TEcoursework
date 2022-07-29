<template>
  <div class="main">
      <the-header></the-header>

      <create-form v-if="$store.state.activeTab === 'create'"></create-form>
      <add-response v-else-if="$store.state.activeTab === 'questions'"></add-response>
      <responses v-else-if="$store.state.activeTab === 'responses'"></responses>
  </div>
</template>

<script>
import TheHeader from './TheHeader.vue';
import CreateForm from './create_form/CreateForm.vue';
import AddResponse from './add_response/AddResponse.vue';
import Responses from './responses/Responses.vue';

export default {
    components: {
        TheHeader,
        CreateForm,
        AddResponse,
        Responses
    }
}
</script>

<style scoped>
.main {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>