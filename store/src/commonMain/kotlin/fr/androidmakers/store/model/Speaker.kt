package fr.androidmakers.store.model

data class Speaker(
        val id: String = "",
        val badges: List<BadgesItem?>? = null,
        val country: String? = null,
        val featured: Boolean? = null,
        val companyLogo: String? = null,
        val name: String? = null,
        val photo: String? = null,
        val bio: String? = null,
        val company: String? = null,
        val socials: List<SocialsItem?>? = null,
        val order: Int? = null
) {

    fun getFullNameAndCompany(): String {
        return this.name + if (company.isNullOrBlank()) "" else ", " + this.company
    }

    fun getMainRibbon(): BadgesItem? {
        return if (badges != null && badges.isNotEmpty()) {
            badges.get(0)
        } else null
    }

}