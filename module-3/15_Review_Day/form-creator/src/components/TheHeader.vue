<template>
    <header>
      <ul>
        <li :class="{ active: $store.state.activeTab === 'create'}" @click="setActiveTab('create')">Create Form</li>
        <li :class="{ active: $store.state.activeTab === 'questions'}" @click="setActiveTab('questions')">Add Response</li>
        <li :class="{ active: $store.state.activeTab === 'responses'}" @click="setActiveTab('responses')">Responses</li>
      </ul>
    </header>
</template>

<script>
export default {
    methods: {
        setActiveTab(activeTab) {
            this.$store.commit('SET_ACTIVE_TAB', activeTab);
        }
    }
}
</script>

<style scoped>
li.active {
  border-bottom: 2px solid black;
}
</style>