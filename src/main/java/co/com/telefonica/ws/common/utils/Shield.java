package co.com.telefonica.ws.common.utils;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;

import java.util.ArrayList;
import java.util.List;

public class Shield {

	private Shield() {}

	public static String blindStr(String value) {
		PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
		return policy.sanitize(value)
				.replace("&#43;", "+")
				.replace("&#39;", "'")
				.replace("&#61;", "=")
				.replace("&amp;", " & ");
	}

	// public static List<BpmInfo> blindBpmInfo(List<BpmInfo> bpmInfoList) {
	// 	PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
	// 	List<BpmInfo> infoList = new ArrayList<>();
	// 	for (BpmInfo item : bpmInfoList) {
	// 		BpmInfo info = new BpmInfo();
	// 		info.setIdType(policy.sanitize(item.getIdType()));
	// 		info.setIdNumber(policy.sanitize(item.getIdNumber()));
	// 		info.setAccessId(policy.sanitize(item.getAccessId()));
	// 		info.setSerialNumber(policy.sanitize(item.getSerialNumber()));
	// 		info.setServiceNumber(policy.sanitize(item.getServiceNumber()));
	// 		infoList.add(info);
	// 	}
	// 	return infoList;
	// }

}
