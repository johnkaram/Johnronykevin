class TabbedFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tabbed, container, false)

        tabLayout = view.findViewById(R.id.tab_layout)
        viewPager = view.findViewById(R.id.view_pager)

        // Set up the tab layout and view pager
        setUpTabs()

        return view
    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(MapFragment(), "Map")
        adapter.addFragment(NotificationsFragment(), "Notifications")
        // Add more fragments for the other tabs
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}
